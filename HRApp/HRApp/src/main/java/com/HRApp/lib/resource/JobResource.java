package com.HRApp.lib.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class JobResource {
    @JsonProperty("jobTitle")
    private  String jobTitle;

    @JsonProperty("jobDescription")
    private String jobDescription;

    @JsonProperty("numberOfPeople")
    private int numberOfPeople;

    @JsonProperty("applicationDate")
    private Date applicationDate;
}
