package com.grupo04.jtscloudnative.temafinal2.appservice.service;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FeignRequest {
	@RequestLine("GET /playlist/{id_playlist}")
	String requestPlaylist(@Param("id_playlist") int id_playlist);
	
	@RequestLine("GET /song/{id_song}")
	String requestSong(@Param("id_song") int id);
	
	@RequestLine("POST /eureka/v2/apps/{appName}")
	@Headers("Content-Type: application/json")
	@Body("{json}")
	void register(@Param("json") String json, @Param("appName") String appName);
	
	@RequestLine("PUT /eureka/v2/apps/{appName}/{instanceID}")
	@Headers("Content-Type: application/json")
	void renew(@Param("appName") String appName, @Param("instanceID") String instanceID);
	
	@RequestLine("GET /eureka/v2/vips/{vipAddress}")
	@Headers({"accept: application/json"})
	String getHosts(@Param("vipAddress") String vipAddress);
}
