package com.grupo04.jtscloudnative.temafinal2.songservice.service;

import java.util.List;

import feign.Feign;

public class EurekaServiceDiscovery implements ServiceDiscovery {
	
	@Override
	public void register(String ip, String port, String appName) {
		String instanceName = buildInstanceID(ip, port, appName);		
		String json = jsonEureka(ip, port, appName, instanceName);
		
		FeignRequest requestRegister = Feign.builder().target(FeignRequest.class, "http://localhost:8080/eureka/v2/apps/"+appName);
		requestRegister.register(json); 
	}
	
	@Override
	public List<String> getHosts(String name) {
		return null;
	}
	
	@Override
	public void renew(String ip, String port, String appName) {
		String instanceID = buildInstanceID(ip, port, appName);
		FeignRequest requestRenew = Feign.builder().target(FeignRequest.class, "http://localhost:8080");
		requestRenew.renew(appName, instanceID);
	}
	
	@Override
	public void deregister(String ip, String port, String appName) {
//		String instanceName = buildInstanceID(ip, port, appName);		
//		String request = jsonEureka(ip, port, appName, instanceName);
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		HttpEntity<String> entity = new HttpEntity<String>(request, headers);
//		try {
//			ResponseEntity<Void> result = restTemplate.exchange(new URI("http://localhost:8080/eureka/v2/apps/" + appName + "/" + instanceName), HttpMethod.DELETE, entity, Void.class);
//			System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	private String buildInstanceID(String ip, String port, String appName) {
		return String.format("%s_%s_%s", appName, ip, port);
	}
	
	public String jsonEureka(String ip, String port, String appName, String instanceName) {
		return "{\n" 
				+ "	\"instance\": {\n" 
						+ "		\"hostName\": \"" + instanceName + "\",\n"
						+ "		\"app\": \"" + appName + "\",\n" 
						+ "		\"vipAddress\": \""+ appName +"\",\n"
						+ "		\"secureVipAddress\": \""+ appName +"\",\n" 
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
