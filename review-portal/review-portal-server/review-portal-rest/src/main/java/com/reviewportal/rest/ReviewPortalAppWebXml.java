package com.reviewportal.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.reviewportal" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ReviewPortalAppWebXml extends SpringBootServletInitializer {

	private final Logger log = LoggerFactory.getLogger(ReviewPortalAppWebXml.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.profiles(addDefaultProfile()).sources(ReviewPortalAppWebXml.class);
	}

	private String addDefaultProfile() {
		String profile = System.getProperty("spring.profiles.active");
		if (profile != null) {
			log.info("Running with Spring profile(s) : {}", profile);
			return profile;
		}

		log.warn("No Spring profile configured, running with default configuration");
		return Constants.SPRING_PROFILE_PRODUCTION;
	}

	// @Override
	// public void onStartup(ServletContext container) throws ServletException {
	// // Dynamic registration = container.addServlet("dispatcher", new
	// // DispatcherServlet());
	// // registration.setLoadOnStartup(1);
	// // registration.addMapping("/*");
	// super.onStartup(container);
	// }

}
