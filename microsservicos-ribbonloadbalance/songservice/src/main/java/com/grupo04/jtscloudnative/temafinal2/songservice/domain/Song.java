package com.grupo04.jtscloudnative.temafinal2.songservice.domain;

public class Song {
    public int id;
    public String title;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + "]";
	}
}
