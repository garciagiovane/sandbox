package com.grupo04.jtscloudnative.temafinal2.appservice.service;

import org.springframework.scheduling.annotation.Scheduled;

public class EurekaHearthbeat {
	private ApplicationConfiguration applicationConfiguration;
	private ServiceDiscovery serviceDiscovery;

	public EurekaHearthbeat(ApplicationConfiguration applicationConfiguration, ServiceDiscovery serviceDiscovery) {
		this.applicationConfiguration = applicationConfiguration;
		this.serviceDiscovery = serviceDiscovery;
	}

	@Scheduled(fixedRate = 30000)
	public void hearthbeat() {
		String port = applicationConfiguration.getPort();
		if (portIsDefined(port))
			serviceDiscovery.renew(applicationConfiguration.getHost(), port, applicationConfiguration.getServiceName());
		System.out.println("Heartbeat " + applicationConfiguration.getServiceName());
	}

	private boolean portIsDefined(String port) {
		return !port.equals("0");
	}
}
