package com.reviewportal.rest.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.reviewportal.rest.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	@Bean
	public ApiInfo getApiInfo() {

		String lName = "Review-Portal";
		String lUrl = "http://reviewportal.com/about/";
		String lEmail = "info@reviewportal.com";

		String lDescription = "Rest API for managing reviews about professionals";
		String lTitle = "Review-Portal-RS-API";
		String lVersion = "1.0.0";

		Contact lContact = new Contact(lName, lUrl, lEmail);

		ApiInfo apiInfo = new ApiInfoBuilder().contact(lContact).description(lDescription).title(lTitle)
				.version(lVersion).build();
		return apiInfo;
	}
}