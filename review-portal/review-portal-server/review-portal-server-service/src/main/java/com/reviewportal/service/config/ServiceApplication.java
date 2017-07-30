package com.reviewportal.service.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.reviewportal")
@EntityScan(basePackages = "com.reviewportal")
@ComponentScan(basePackages = { "com.reviewportal" })
public class ServiceApplication {
}
