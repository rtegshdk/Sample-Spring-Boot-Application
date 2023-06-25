package com.example.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PopulationCount {

    @JsonProperty("year")
    private String year;
    @JsonProperty("value")
    private String value;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("reliabilty")
    private String reliabilty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
