package com.reviewportal.service.impl.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.reviewportal.dao.config.DaoApplication;

//@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class, })
@EnableJpaRepositories(basePackages = "com.reviewportal")
@EntityScan(basePackages = "com.reviewportal")
@ComponentScan(basePackages = { "com.reviewportal" })
@EnableAutoConfiguration//(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class, })
@Import({ DaoApplication.class })
public class ServiceApplication {
}
