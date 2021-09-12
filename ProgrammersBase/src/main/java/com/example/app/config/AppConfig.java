package com.example.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.example.app.config")
@Import({
	AsyncConfiguration.class
})
public class AppConfig {

	
}
