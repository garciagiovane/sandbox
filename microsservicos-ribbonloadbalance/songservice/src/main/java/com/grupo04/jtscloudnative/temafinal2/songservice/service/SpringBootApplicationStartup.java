package com.grupo04.jtscloudnative.temafinal2.songservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringBootApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private EurekaServiceDiscovery eurekaService;
	
	@Autowired
	private EmbeddedWebApplicationContext embeddedWebApplicationContext;
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		Integer port = embeddedWebApplicationContext.getEmbeddedServletContainer().getPort();
		eurekaService.register("localhost", port.toString(), "SongService");
	}
}