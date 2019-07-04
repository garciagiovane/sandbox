package com.grupo04.jtscloudnative.temafinal2.songservice.service;

import java.util.List;

public interface ServiceDiscovery {
	void register(String ip, String port, String appName);
	List<String> getHosts(String name);
	void renew(String ip, String port, String appName);
	void deregister(String ip, String port, String appName);
}
