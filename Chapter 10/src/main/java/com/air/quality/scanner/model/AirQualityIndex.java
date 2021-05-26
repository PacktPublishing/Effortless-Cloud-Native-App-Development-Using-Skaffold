package com.air.quality.scanner.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AirQualityIndex {
    public String aqi;
    public String level;
    public String implications;
    public String warning;
}
