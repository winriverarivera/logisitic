package com.logistic.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Michael Valle 
 *         Wilbert Marcia
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket politicaInstuticionalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("logisitic-bodegas")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.logistic.controller.config"))
                .paths(regex("/bodegas.*"))
                .build()
                .apiInfo(metaData());
    }
    
    
    @Bean
    public SecurityConfiguration security() {
        return new SecurityConfiguration(
                null,
                null,
                null, // realm Needed for authenticate button to work
                null, // appName Needed for authenticate button to work
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTQwODYwNyIsInVzZXJJZCI6Ii0yMTQ3NDgzNjQ4Iiwicm9sZSI6IlVTRVIifQ.WXpEJ-jypV2TQa1VWP-qiajfmjXfMh9w_z6JZI6Xdth7aZxlJ5sgWRKXyB8Mh3cYoCtZBCujSsWuRTg6OO2ecA",// apiKeyValue
                ApiKeyVehicle.HEADER,
                "Authorization",
                null);
    }
    
    
    @SuppressWarnings("deprecation")
    private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
                "<logisdtic - Spring Boot REST API",
                "REST API para el proyecto Logisitic",
                "1.0",
                "",
                "",
                "",
                "Privada");
        return apiInfo;
    }
 

}