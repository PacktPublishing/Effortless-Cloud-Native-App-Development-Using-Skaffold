package com.air.quality.scanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measurement {
    public String parameter;
    public String value;
    public String unit;
}
