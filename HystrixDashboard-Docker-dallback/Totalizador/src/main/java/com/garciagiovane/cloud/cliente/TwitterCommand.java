package com.garciagiovane.cloud.cliente;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class TwitterCommand extends HystrixCommand<String> {
	private final String url;

	public TwitterCommand(String url) {
		super(HystrixCommandGroupKey.Factory.asKey("Api"));
		this.url = url;
	}

	@Override
	protected String run() throws Exception {
		return new RestTemplate().getForObject(url, String.class);
	}

	@Override
	protected String getFallback() {
		return "{\"mensagem\":\"usuario nao encontrado\"}";
	}
}
