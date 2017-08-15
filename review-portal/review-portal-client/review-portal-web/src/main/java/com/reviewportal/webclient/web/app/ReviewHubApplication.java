package com.reviewportal.webclient.web.app;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.ProjectStage;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import org.apache.catalina.Context;
import org.primefaces.util.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.reviewportal.service.impl.config.ServiceApplication;
import com.sun.faces.config.FacesInitializer;

@Configuration
@ComponentScan(basePackages = "com.reviewportal")
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })
@Import({ServiceApplication.class})
public class ReviewHubApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReviewHubApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ReviewHubApplication.class);
    }

    // @Bean
    // public static CustomScopeConfigurer customScopeConfigurer() {
    // CustomScopeConfigurer configurer = new CustomScopeConfigurer();
    // configurer.setScopes(Collections.<String,
    // Object>singletonMap(FacesViewScope.NAME, new FacesViewScope()));
    // return configurer;
    // }

    @Bean
    public ServletContextInitializer servletContextCustomizer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext sc) throws ServletException {
                sc.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/primefaces-avalon.taglib.xml");
                sc.setInitParameter(Constants.ContextParams.THEME, "avalon-blue");
                sc.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
                sc.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
            }
        };
    }

    // @Bean
    // public TomcatEmbeddedServletContainerFactory tomcatFactory() {
    // return new TomcatEmbeddedServletContainerFactory() {
    //
    // @Override
    // protected TomcatEmbeddedServletContainer
    // getTomcatEmbeddedServletContainer(Tomcat tomcat) {
    // tomcat.enableNaming();
    // return super.getTomcatEmbeddedServletContainer(tomcat);
    // }
    // };
    // }

    /**
     * This bean is only needed when running with embedded Tomcat.
     */
    @Bean
    // @ConditionalOnMissingBean(NonEmbeddedServletContainerFactory.class)
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

        tomcat.addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                // register FacesInitializer
                context.addServletContainerInitializer(new FacesInitializer(),
                        getServletContainerInitializerHandlesTypes(FacesInitializer.class));

                // add configuration from web.xml
                context.addWelcomeFile("views/pg-landing.xhtml");

                // register additional mime-types that Spring Boot doesn't
                // register
                context.addMimeMapping("eot", "application/vnd.ms-fontobject");
                context.addMimeMapping("ttf", "application/font-sfnt");
                context.addMimeMapping("woff", "application/font-woff");
                context.addMimeMapping("woff2", "application/font-woff2");
                context.addMimeMapping("woff2", "application/font-woff2");
                context.addMimeMapping("eot?#iefix", "application/vnd.ms-fontobject");
                context.addMimeMapping("svg", "image/svg+xml");

                context.addMimeMapping("svg#exosemibold", "image/svg+xml");

                context.addMimeMapping("svg#exobolditalic", "image/svg+xml");
                context.addMimeMapping("svg#exomedium</extension>", "image/svg+xml");
                context.addMimeMapping("svg#exoregular", "image/svg+xml");
                context.addMimeMapping("svg#fontawesomeregular", "image/svg+xml");
            }
        });

        return tomcat;
    }

    @SuppressWarnings("rawtypes")
    private Set<Class<?>> getServletContainerInitializerHandlesTypes(
            Class<? extends ServletContainerInitializer> sciClass) {
        HandlesTypes annotation = sciClass.getAnnotation(HandlesTypes.class);
        if (annotation == null) {
            return Collections.emptySet();
        }

        Class[] classesArray = annotation.value();
        Set<Class<?>> classesSet = new HashSet<Class<?>>(classesArray.length);
        for (Class clazz : classesArray) {
            classesSet.add(clazz);
        }

        return classesSet;
    }

}