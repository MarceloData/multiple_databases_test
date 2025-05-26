package com.tests.profiles;

import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class OracleProfile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "%test.quarkus.datasource.oracle.jdbc.url",
                "jdbc:h2:mem:oracle;MODE=ORACLE;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:db/scripts/initOracle.sql'");
    }

    @Override
    public String getConfigProfile() {
        return "test";
    }

}
