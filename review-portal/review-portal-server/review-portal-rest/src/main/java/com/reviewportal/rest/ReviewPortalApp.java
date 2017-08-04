package com.reviewportal.rest;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication(scanBasePackages = { "com.reviewportal" })
public class ReviewPortalApp {

	private final Logger logger = LoggerFactory.getLogger(ReviewPortalApp.class.getName());

	@Autowired
	private Environment env;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(ReviewPortalApp.class);

		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

		addDefaultProfile(app, source);
		addLiquibaseScanPackages();
		app.run(args);
	}

	@PostConstruct
	public void initApplication() throws IOException {
		if (env.getActiveProfiles().length == 0) {
			logger.warn("No Spring profile configured, running with default configuration");
		} else {
			logger.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
		}
	}

	/**
	 * Set a default profile if it has not been set
	 */
	private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
		if (!source.containsProperty("spring.profiles.active")) {
			app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
		}
	}

	/**
	 * Set the liquibases.scan.packages to avoid an exception from
	 * ServiceLocator.
	 */
	private static void addLiquibaseScanPackages() {
		System.setProperty("liquibase.scan.packages",
				"liquibase.change" + "," + "liquibase.database" + "," + "liquibase.parser" + ","
						+ "liquibase.precondition" + "," + "liquibase.datatype" + "," + "liquibase.serializer" + ","
						+ "liquibase.sqlgenerator" + "," + "liquibase.executor" + "," + "liquibase.snapshot" + ","
						+ "liquibase.logging" + "," + "liquibase.diff" + "," + "liquibase.structure" + ","
						+ "liquibase.structurecompare" + "," + "liquibase.lockservice" + "," + "liquibase.ext" + ","
						+ "liquibase.changelog");
	}
}