package com.tests.profiles;

import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class Db2Profile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.datasource.jdbc.url",
                "jdbc:h2:mem:db2;MODE=DB2;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:db/scripts/initdb2.sql'",
                "quarkus.datasource.username", "sa",
                "quarkus.datasource.password", "sa",
                "quarkus.datasource.jdbc.driver", "org.h2.Driver");
    }
}
