package com.packt.chapter6.reactive;

import com.packt.chapter6.reactive.model.Employee;
import com.packt.chapter6.reactive.repository.EmployeeRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.util.List;

@SpringBootApplication
public class ReactiveApplication {
    private static final Logger logger = LoggerFactory.getLogger(ReactiveApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {
        return args -> {
            List<Employee> employees = List.of(
                    new Employee("Peter", "Parker", 25, 20000),
                    new Employee("Tony", "Stark", 30, 40000),
                    new Employee("Clark", "Kent", 31, 60000),
                    new Employee("Bruce", "Wayne", 33, 100000)
            );
            logger.info("Saving employee " + employeeRepository.saveAll(employees).subscribe());
        };
    }
}
