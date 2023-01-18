package com.redhat.demo.dataformatdemo;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.annotation.Configurations;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.redhat.demo.dataformatdemo")
public class DataformatdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataformatdemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean camelServletRegistrationBean() {
	  ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel/*");
	  registration.setName("CamelServlet");
	  return registration;
	}
}
