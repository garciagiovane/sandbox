package com.grupo04.jtscloudnative.temafinal2.songservice.service;

import com.google.gson.Gson;
import com.grupo04.jtscloudnative.temafinal2.songservice.dao.SongDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SongCommand extends HystrixCommand<String> {
    private int id;

    public SongCommand(int id) {
        super(HystrixCommandGroupKey.Factory.asKey("SongService")/* increase requisition time if needed */);
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        return new Gson().toJson(new SongDao().searchById(id));
    }
    
    @Override
    protected String getFallback() {
        return new Gson().toJson("song not found!");
    }
}
