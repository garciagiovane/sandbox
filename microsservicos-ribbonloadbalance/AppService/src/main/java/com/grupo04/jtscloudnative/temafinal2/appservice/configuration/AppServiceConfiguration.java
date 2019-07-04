package com.grupo04.jtscloudnative.temafinal2.appservice.configuration;

import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.grupo04.jtscloudnative.temafinal2.appservice.controller.AppServiceController;
import com.grupo04.jtscloudnative.temafinal2.appservice.service.AppServiceCommand;
import com.grupo04.jtscloudnative.temafinal2.appservice.service.ApplicationConfiguration;
import com.grupo04.jtscloudnative.temafinal2.appservice.service.EurekaHearthbeat;
import com.grupo04.jtscloudnative.temafinal2.appservice.service.EurekaServiceDiscovery;
import com.grupo04.jtscloudnative.temafinal2.appservice.service.RibbonLoadBalance;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
@ComponentScan("com.grupo04.jtscloudnative.temafinal2.appservice")
public class AppServiceConfiguration {	
	@Bean
	@Scope("prototype")
	public AppServiceController appServiceController() {
		return new AppServiceController();
	}
	
	@Bean
	@Scope("prototype")
	public AppServiceCommand appServiceCommand() {
		return new AppServiceCommand();
	}
	
	@Bean
	public RibbonLoadBalance ribbonLoadBalance() {
		return new RibbonLoadBalance();
	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
	}
	
	@Bean
	public EurekaServiceDiscovery eurekaServiceDiscovery() {
		return new EurekaServiceDiscovery();
	}

	@Bean
	public ApplicationConfiguration springUtils(EmbeddedWebApplicationContext context) {
		return new ApplicationConfiguration(context, "AppService");
	}

	@Bean
	public EurekaHearthbeat eurekaHearthbeat(ApplicationConfiguration springUtils,
			EurekaServiceDiscovery serviceDiscovery) {
		return new EurekaHearthbeat(springUtils, serviceDiscovery);
	}
}
