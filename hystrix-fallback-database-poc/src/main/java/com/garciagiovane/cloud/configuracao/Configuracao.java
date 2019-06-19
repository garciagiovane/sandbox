package com.garciagiovane.cloud.configuracao;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
@ComponentScan("com.garciagiovane.cloud")
public class Configuracao {
	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean() {
		return new ServletRegistrationBean<Servlet>(new HystrixMetricsStreamServlet(), "/hystrix.stream");
	}
}
