package com.tests.models.modelsHive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Language {

    @JsonProperty("languageId")
    private Long languageId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastUpdate")
    private String lastUpdate;
}
