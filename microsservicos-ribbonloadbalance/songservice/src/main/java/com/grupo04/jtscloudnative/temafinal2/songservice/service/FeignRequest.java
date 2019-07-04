package com.grupo04.jtscloudnative.temafinal2.songservice.service;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FeignRequest {
	@RequestLine("POST")
	@Headers("Content-Type: application/json")
	@Body("{json}")
	void register(@Param("json") String json);
	
	@RequestLine("PUT /eureka/v2/apps/{appName}/{instanceID}")
	void renew(@Param("appName") String appName,@Param("instanceID") String instanceID);
}
