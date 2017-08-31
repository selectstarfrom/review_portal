package com.reviewportal.webapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import com.reviewportal.model.core.IAppLauncher;
import com.reviewportal.service.impl.config.ServiceApplication;

import nz.net.ultraq.thymeleaf.LayoutDialect;

// @formatter:off
@SpringBootApplication
@ComponentScan(
		basePackages = {"com.reviewportal.webapp", },
		excludeFilters = @Filter(type = FilterType.ANNOTATION, value = IAppLauncher.class)
)
@EnableJpaRepositories("org.baeldung.persistence.repo")
@EntityScan("org.baeldung.persistence.model")
@Import(value=ServiceApplication.class)
//@formatter:on
public class Application {

    public static void main(String[] pArgs) {
        SpringApplication.run(Application.class, pArgs);
    }
    

}