package com.grupo04.jtscloudnative.temafinal2.appservice.domain;

public class Song {
	private String music;
	
	public Song(String musicTitle) {
		this.music = musicTitle;
	}
	
	public String getMusicTitle() {
		return music;
	}
	public void setMusicTitle(String musicTitle) {
		this.music = musicTitle;
	}
	@Override
	public String toString() {
		return "Playlist [musicTitle=" + music + "]";
	}
}
