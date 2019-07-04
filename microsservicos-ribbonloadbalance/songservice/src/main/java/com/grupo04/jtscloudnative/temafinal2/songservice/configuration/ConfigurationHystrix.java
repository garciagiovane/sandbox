package com.grupo04.jtscloudnative.temafinal2.songservice.configuration;

import com.grupo04.jtscloudnative.temafinal2.songservice.service.ApplicationConfiguration;
import com.grupo04.jtscloudnative.temafinal2.songservice.service.EurekaHearthbeat;
import com.grupo04.jtscloudnative.temafinal2.songservice.service.EurekaServiceDiscovery;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.grupo04.jtscloudnative.temafinal2")
public class ConfigurationHystrix {

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
	}

	@Bean
	public EurekaServiceDiscovery eurekaServiceDiscovery() {
		return new EurekaServiceDiscovery();
	}

	@Bean
	public ApplicationConfiguration springUtils(EmbeddedWebApplicationContext context) {
		return new ApplicationConfiguration(context, "SongService");
	}

	@Bean
	public EurekaHearthbeat eurekaHearthbeat(ApplicationConfiguration springUtils,
			EurekaServiceDiscovery serviceDiscovery) {
		return new EurekaHearthbeat(springUtils, serviceDiscovery);
	}
}