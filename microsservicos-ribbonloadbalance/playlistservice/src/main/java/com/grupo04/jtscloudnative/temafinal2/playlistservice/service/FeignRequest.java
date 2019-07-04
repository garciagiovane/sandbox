package com.grupo04.jtscloudnative.temafinal2.playlistservice.service;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FeignRequest {
	@RequestLine("POST /eureka/v2/apps/{appName}")
	@Headers("Content-Type: application/json")
	@Body("{json}")
	void register(@Param("json") String json, @Param("appName") String appName);
	
	@RequestLine("PUT /eureka/v2/apps/{appName}/{instanceID}")
	@Headers("Content-Type: application/json")
	void renew(@Param("appName") String appName, @Param("instanceID") String instanceID);
}
