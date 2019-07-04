package com.grupo04.jtscloudnative.temafinal2.playlistservice.domain;

import java.util.List;

public class Playlist {
    private int id;
    private List<Integer> songsId;

    public Playlist(int id, List<Integer> songs) {
        this.id = id;
        this.songsId = songs;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getSongsId() {
        return songsId;
    }
}
