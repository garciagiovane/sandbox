package com.garciagiovane.cloud.cliente;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class AppConfig {
	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean(){
		ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<Servlet>(new HystrixMetricsStreamServlet(), "/hystrix.stream");
		return registration;
	}
}
