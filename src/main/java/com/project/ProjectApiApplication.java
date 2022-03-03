package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.project.properties.ProjectApiProperty;

/**
 * 
 * @author RochaDev
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ProjectApiProperty.class)
public class ProjectApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiApplication.class, args);
	}

}
