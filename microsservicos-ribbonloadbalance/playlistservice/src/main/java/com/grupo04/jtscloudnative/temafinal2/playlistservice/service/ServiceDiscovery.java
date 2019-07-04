package com.grupo04.jtscloudnative.temafinal2.playlistservice.service;

import java.util.List;

public interface ServiceDiscovery {
	void register(String ip, String port, String appName);
	List<String> getHosts(String name);
	void renew(String ip, String port, String appName);
}
