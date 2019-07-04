package com.grupo04.jtscloudnative.temafinal2.appservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class AppServiceCommand extends HystrixCommand<String> {
	private int idPlaylist;
	
	@Autowired
	private RibbonLoadBalance ribbonLoadBalance;
	
	public AppServiceCommand() {
		super(HystrixCommandGroupKey.Factory.asKey("AppService")/* increase requisition time if needed */);
	}
	
	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}
	
	@Override
	protected String run() throws Exception {
		return new Gson().toJson(ribbonLoadBalance.getSongs(idPlaylist));
	}

	@Override
	protected String getFallback() {
		return new Gson().toJson("playlist not found");
	}
}