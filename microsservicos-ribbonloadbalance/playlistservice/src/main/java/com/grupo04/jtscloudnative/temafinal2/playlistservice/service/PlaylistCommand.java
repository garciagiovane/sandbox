package com.grupo04.jtscloudnative.temafinal2.playlistservice.service;

import com.google.gson.Gson;
import com.grupo04.jtscloudnative.temafinal2.playlistservice.dao.PlaylistDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class PlaylistCommand extends HystrixCommand<String> {
    private int id;

    public PlaylistCommand(int id) {
        super(HystrixCommandGroupKey.Factory.asKey("PlaylistService")/* increase requisition time if needed */);
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        return new Gson().toJson(new PlaylistDao().searchById(id).getSongsId());
    }

    @Override
    protected String getFallback() {
        return new Gson().toJson("Playlist nao encontrada!");
    }
}