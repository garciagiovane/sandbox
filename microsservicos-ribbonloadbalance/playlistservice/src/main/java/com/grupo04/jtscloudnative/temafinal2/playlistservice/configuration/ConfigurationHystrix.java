package com.grupo04.jtscloudnative.temafinal2.playlistservice.configuration;

import com.grupo04.jtscloudnative.temafinal2.playlistservice.service.ApplicationConfiguration;
import com.grupo04.jtscloudnative.temafinal2.playlistservice.service.EurekaHearthbeat;
import com.grupo04.jtscloudnative.temafinal2.playlistservice.service.EurekaServiceDiscovery;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.grupo04.jtscloudnative.temafinal2.playlistservice")
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
		return new ApplicationConfiguration(context, "PlaylistService");
	}

	@Bean
	public EurekaHearthbeat eurekaHearthbeat(ApplicationConfiguration springUtils,
			EurekaServiceDiscovery serviceDiscovery) {
		return new EurekaHearthbeat(springUtils, serviceDiscovery);
	}
}
