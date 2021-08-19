package com.air.quality.scanner.controller;

import com.air.quality.scanner.model.AqiCountryResponse;
import com.air.quality.scanner.model.Location;
import com.air.quality.scanner.model.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;

@Controller
@RequestMapping("/index")
public class AirQualityController {

    private static final String COUNTRY_AQI_END_POINT = "https://api.openaq.org/v1/latest?country";
    private static final Logger LOGGER = LoggerFactory.getLogger(AirQualityController.class);
    private RestTemplate restTemplate;

    @Bean
    private RestTemplate createRestTemplate(RestTemplateBuilder builder) {
        restTemplate = builder.setReadTimeout(Duration.ofSeconds(60)).build();
        return restTemplate;
    }
    private AqiCountryResponse getAqiForCountry(String code, String limit, String page, String city) {
        LOGGER.info("URL " + COUNTRY_AQI_END_POINT + "=" + code + "&" + "limit" + "=" + limit + "&" + "page" + "=" + page + "&" + "city" + "=" + city);
        return restTemplate.getForObject(COUNTRY_AQI_END_POINT + "=" + code + "&" + "limit" + "=" + limit + "&" + "page" + "=" + page + "&" + "city" + "=" + city, AqiCountryResponse.class);
    }
    @GetMapping
    public String index(@RequestParam(value = "country", required = true, defaultValue = "IN") String country,
                        @RequestParam(value = "limit", required = true, defaultValue = "5") String limit,
                        @RequestParam(value = "page", required = true, defaultValue = "1") String page,
                        @RequestParam(value = "city", required = true, defaultValue = "Delhi") String city,
                        Model model) {
        var aqiForCountry = getAqiForCountry(country, limit, page, city).getResults();
        for (Location location : aqiForCountry) {
            Collections.sort(location.getMeasurements(), Comparator.comparing(Measurement::getParameter).thenComparing(Measurement::getValue));
        }
        model.addAttribute("response", aqiForCountry);
        return "index";
    }
}
