package com.grupo04.jtscloudnative.temafinal2.appservice.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;

import io.netty.buffer.ByteBuf;

public class RibbonLoadBalance {
	@Autowired
	private EurekaServiceDiscovery eurekaServiceDiscovery;
	
	public List<String> getSongs(int idPlaylist) {
		return getSongTitle(parseJsonPlaylist(getPlaylistIDs(idPlaylist)));
	}
	
	private String getPlaylistIDs(int idPlaylist) {
		HttpResourceGroup httpResourceGroup = Ribbon.createHttpResourceGroup("appService",
				ClientOptions.create().withMaxAutoRetriesNextServer(3).withConfigurationBasedServerList(listarHosts("PLAYLISTSERVICE")));

		@SuppressWarnings("unchecked")
		HttpRequestTemplate<ByteBuf> pingIdTemplate = httpResourceGroup
				.newTemplateBuilder("appServiceTemplate", ByteBuf.class).withMethod("GET").withUriTemplate("/playlist/{id}")
				.build();

		ByteBuf numberPrinted = pingIdTemplate.requestBuilder().withRequestProperty("id", idPlaylist).build()
				.execute();
		return numberPrinted.toString(Charset.defaultCharset());
	}
	
	private List<String> getSongTitle(JsonArray musicsId) {
		List<String> musicsTitle = new ArrayList<String>();		

		HttpResourceGroup httpResourceGroup = Ribbon.createHttpResourceGroup("appService", ClientOptions.create()
				.withMaxAutoRetriesNextServer(3).withConfigurationBasedServerList(listarHosts("SONGSERVICE")));

		@SuppressWarnings("unchecked")
		HttpRequestTemplate<ByteBuf> pingIdTemplate = httpResourceGroup
				.newTemplateBuilder("appServiceTemplate", ByteBuf.class).withMethod("GET")
				.withUriTemplate("/song/{id}").build();
		
		for (JsonElement id : musicsId) {
			ByteBuf numberPrinted = pingIdTemplate.requestBuilder().withRequestProperty("id", id.getAsInt()).build()
					.execute();
			JsonObject musicFound = new JsonParser().parse(numberPrinted.toString(Charset.defaultCharset())).getAsJsonObject();
			musicsTitle.add(musicFound.get("title").getAsString());
		}
		return musicsTitle;
	}
	
	private JsonArray parseJsonPlaylist(String jsonPlaylist) {
		return new JsonParser().parse(jsonPlaylist).getAsJsonArray();
	}
	
	private String listarHosts(String vipAddressServico) {
		String LIST_OF_HOSTS = "";
		List<String> hosts = eurekaServiceDiscovery.getHosts(vipAddressServico);		
		
		for (String string : hosts) {
			LIST_OF_HOSTS += LIST_OF_HOSTS.concat(string + ",");
		}
		return LIST_OF_HOSTS;
	}
}
