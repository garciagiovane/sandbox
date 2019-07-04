package com.grupo04.jtscloudnative.temafinal2.playlistservice.service;

import java.util.List;

import feign.Feign;

public class EurekaServiceDiscovery implements ServiceDiscovery {
	
	@Override
	public void register(String ip, String port, String appName) {
		String instanceName = buildInstanceID(ip, port, appName);		
		String json = jsonEureka(ip, port, appName, instanceName);
		
		FeignRequest request = Feign.builder().target(FeignRequest.class, "http://localhost:8080");
		request.register(json, appName);
	}
	
	@Override
	public List<String> getHosts(String name) {
		return null;
	}
	
	@Override
	public void renew(String ip, String port, String appName) {
		String instanceID = buildInstanceID(ip, port, appName);
		
		FeignRequest request = Feign.builder().target(FeignRequest.class, "http://localhost:8080");
		request.renew(appName, instanceID); 
	}

	private String buildInstanceID(String ip, String port, String appName) {
		return String.format("%s_%s_%s", appName, ip, port);
	}
	
	public String jsonEureka(String ip, String port, String appName, String instanceName) {
		return "{\n" 
				+ "	\"instance\": {\n" 
						+ "		\"hostName\": \"" + instanceName + "\",\n"
						+ "		\"app\": \"" + appName + "\",\n" 
						+ "		\"vipAddress\": \"" + appName + "\",\n"
						+ "		\"secureVipAddress\": \"" + appName + "\",\n" 
						+ "		\"ipAddr\": \"" + ip + "\",\n"
						+ "		\"status\": \"UP\",\n"
						+ "		\"port\": {\"$\": \"" + port + "\", \"@enabled\": \"true\"},\n"
						+ "		\"securePort\": {\"$\": \"8443\", \"@enabled\": \"true\"},\n"
						+ "		\"healthCheckUrl\": \"http://" + ip + ":" + port + "/healthcheck\",\n"
						+ "		\"statusPageUrl\": \"http://" + ip + ":" + port + "/status\",\n"
						+ "		\"homePageUrl\": \"http://" + ip + ":" + port + "\",\n" 
						+ "		\"dataCenterInfo\": {\n"
						+ "		\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n"
						+ "		\"name\": \"MyOwn\"\n" 
						+ "		}\n" 
						+ "	}\n" 
						+ "}";
	}
}
