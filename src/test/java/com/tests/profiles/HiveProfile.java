package com.tests.profiles;

import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class HiveProfile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.datasource.jdbc.url",
                "jdbc:h2:mem:hive;MODE=MySQL;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:db/scripts/initHive.sql'",
                "quarkus.datasource.username", "sa",
                "quarkus.datasource.password", "sa",
                "quarkus.datasource.jdbc.driver", "org.h2.Driver");
    }
}
