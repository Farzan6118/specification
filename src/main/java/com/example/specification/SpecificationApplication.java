package com.example.specification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpecificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecificationApplication.class, args);
    }

}
