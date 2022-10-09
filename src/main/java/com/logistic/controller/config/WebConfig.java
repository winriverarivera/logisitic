package com.logistic.controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan({"com.logistic"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@ServletComponentScan(basePackages = {"com.logistic.servlet"})
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class WebConfig extends WebSecurityConfigurerAdapter{
	//@Autowired Environment env;
	
		 @Override
		    protected void configure(HttpSecurity http) throws Exception {
		    	http.csrf().disable()
		        	.authorizeRequests().antMatchers("**/rest/**").anonymous()
		        	.and()
		        	.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "**/rest/**").permitAll()
		        	.and()
		        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		        http.headers().cacheControl();
		        http.addFilter(corsFilter());
		    }

		 @Bean
		    public CorsFilter corsFilter() {
		        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		        CorsConfiguration config = new CorsConfiguration();
		        config.setAllowCredentials(true);		        
		        config.addAllowedOrigin("*");
		        config.addAllowedHeader("*");		        
		        config.addAllowedMethod("OPTIONS");
		        config.addAllowedMethod("GET");
		        config.addAllowedMethod("POST");
		        config.addAllowedMethod("PUT");
		        config.addAllowedMethod("DELETE");
		        source.registerCorsConfiguration("/**", config);
		        return new CorsFilter(source);
		    }
/*
		 @Bean
		    @Primary
		    @ConfigurationProperties(prefix = "spring.datasource")
		    public DataSource devDataSource() {
		        return DataSourceBuilder.create().build();
		    }*/
		 @Bean(name = "multipartResolver")
		    public CommonsMultipartResolver multipartResolver() {
		        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		        return multipartResolver;
		    }
		 @Profile({"dev"})
			@Bean
			@Primary
			@ConfigurationProperties(prefix = "spring.datasource")
			public DataSource primarioDataSource() {
				return DataSourceBuilder.create().build();
			}
			
			@Profile("test")
		    @Bean
		    @Primary
		    @ConfigurationProperties(prefix = "spring.datasource")
		    public DataSource testDataSource() {
		        String ds = "java:/jboss/AUDITORIA_DS";
		        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		        DataSource dataSource = dataSourceLookup.getDataSource(ds);
		        return dataSource;
		    }
			
			@Profile("prod")
		    @Bean
		    @Primary
		    @ConfigurationProperties(prefix = "spring.datasource")
		    public DataSource prodDataSource() {
		        String ds = "java:/jboss/AUDITORIA_DS";
		        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		        DataSource dataSource = dataSourceLookup.getDataSource(ds);
		        return dataSource;
		    }	 	

		 
}
