package com.tests.cache;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.SetArgs;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RedisCache {

    private final RedisDataSource redisDataSource;

    @Inject
    @ConfigProperty(name = "cache-default-ttl", defaultValue = "60")
    long defaultTtlInSeconds;

    public RedisCache(RedisDataSource redisDataSource) {
        this.redisDataSource = redisDataSource;
    }

    private Duration getDefaultTtl() {
        return Duration.ofSeconds(defaultTtlInSeconds);
    }

    public <T> T get(String key, Class<T> clazz) {
        ValueCommands<String, T> commands = redisDataSource.value(clazz);
        return commands.get(key);
    }

    public <T> void set(String key, T value, Duration ttl) {
        @SuppressWarnings("unchecked")
        ValueCommands<String, T> commands = redisDataSource.value((Class<T>) value.getClass());
        commands.set(key, value, new SetArgs().ex(ttl));
    }

    public void evict(String key) {
        ValueCommands<String, String> commands = redisDataSource.value(String.class);
        commands.getdel(key);
    }

    public <T> T getOrSetIfAbsent(String key, Supplier<T> computation, Duration ttl, Class<T> clazz) {
        T cached = get(key, clazz);
        if (cached != null) {
            return cached;
        } else {
            T result = computation.get();
            set(key, result, ttl);
            return result;
        }
    }

    public <T> T getOrSetIfAbsent(String key, Supplier<T> computation, Class<T> clazz) {
        return getOrSetIfAbsent(key, computation, getDefaultTtl(), clazz);
    }

    public <T> List<T> getOrSetIfAbsent(String key, Supplier<List<T>> computation, Duration ttl) {
        @SuppressWarnings("unchecked")
        List<T> cached = get(key, List.class);
        if (cached != null) {
            return cached;
        } else {
            List<T> result = computation.get();
            set(key, result, ttl);
            return result;
        }
    }

    public <T> List<T> getOrSetIfAbsent(String key, Supplier<List<T>> computation) {
        return getOrSetIfAbsent(key, computation, getDefaultTtl());
    }

    public <K, V> void setMap(String key, Map<K, V> map, Duration ttl) {
        String jsonMap = serializeMap(map);
        ValueCommands<String, String> commands = redisDataSource.value(String.class);
        commands.set(key, jsonMap, new SetArgs().ex(ttl));
    }

    public <K, V> String serializeMap(Map<K, V> map) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(map);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing map", e);
        }
    }

    public <K, V> Map<K, V> getMap(String key, Class<K> keyType, Class<V> valyeType) {
        ValueCommands<String, String> commands = redisDataSource.value(String.class);
        String jsonMap = commands.get(key);
        if (jsonMap != null) {
            return deserializeMap(jsonMap, keyType, valyeType);
        }
        return null;
    }

    private <K, V> Map<K, V> deserializeMap(String jsonMap, Class<K> keyType, Class<V> valueType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonMap, new TypeReference<Map<K, V>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing map", e);
        }
    }

    public <K, V> Map<K, V> getOrSetIfAbsent(String key, Supplier<Map<K, V>> computation, Class<K> keyType,
            Class<V> valueType, Duration ttl) {
        Map<K, V> cached = getMap(key, keyType, valueType);
        if (cached != null) {
            return cached;
        } else {
            Map<K, V> result = computation.get();
            set(key, result, ttl);
            return result;
        }
    }

    public <K, V> Map<K, V> getOrSetIfAbsent(String key, Supplier<Map<K, V>> computation, Class<K> keyType,
            Class<V> valueType) {
        return getOrSetIfAbsent(key, computation, keyType, valueType, getDefaultTtl());
    }
}
