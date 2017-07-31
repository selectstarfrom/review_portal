package com.reviewportal.dao.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.reviewportal")
@EntityScan(basePackages = "com.reviewportal")
public class DaoApplication {
}
