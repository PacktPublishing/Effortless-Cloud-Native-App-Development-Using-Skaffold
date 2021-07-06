package com.air.quality.scanner;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.ServiceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@KubernetesApplication(serviceType = ServiceType.LoadBalancer, replicas = 2, expose = true)
public class AirQualityScannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirQualityScannerApplication.class, args);
    }

}
