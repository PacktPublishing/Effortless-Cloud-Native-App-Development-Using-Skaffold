package com.air.quality.scanner;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.ServiceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@KubernetesApplication(serviceType = ServiceType.LoadBalancer)
@SpringBootApplication
public class AirQualityScannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirQualityScannerApplication.class, args);
    }

}
