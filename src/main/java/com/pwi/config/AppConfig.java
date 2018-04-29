package com.pwi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Nabeel
 * @version 1.0
 * The purpose of this class is to scan all components and load the application.properties file.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.pwi")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
