package com.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.spring.web.plugins.Docket;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class LogisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticApplication.class, args);
	}
	
	//nuevo
		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}

		@Bean
		public Docket api() throws IOException, XmlPullParserException {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model model = reader.read(new FileReader("pom.xml"));
			ApiInfoBuilder builder = new ApiInfoBuilder()
					.title("Person Service Api Documentation")
					.description("Documentation automatically generated")
					.version(model.getVersion())
					.contact(new Contact("Piotr Mińkowski", "piotrminkowski.wordpress.com", "piotr.minkowski@gmail.com"));
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.logistic.controller.config"))
					.paths(PathSelectors.any()).build()
					.apiInfo(builder.build());
		}
	
}
