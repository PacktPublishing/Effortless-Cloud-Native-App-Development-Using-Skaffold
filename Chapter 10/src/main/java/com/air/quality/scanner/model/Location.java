package com.air.quality.scanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    public String location;
    public String city;
    public List<Measurement> measurements;
}
