package com.grupo04.jtscloudnative.temafinal2.appservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo04.jtscloudnative.temafinal2.appservice.service.AppServiceCommand;

@RestController
@RequestMapping(value = "app")
public class AppServiceController {
	@Autowired
	private AppServiceCommand appServiceCommand;

//	public AppServiceController(AppServiceCommand appServiceCommand) {
//		this.appServiceCommand = appServiceCommand;
//	}

	@GetMapping(value = "/playlist/{idPlaylist}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> requestHandler(@PathVariable("idPlaylist") int idPlaylist) {
		appServiceCommand.setIdPlaylist(idPlaylist);
		return new ResponseEntity<String>(appServiceCommand.execute(), HttpStatus.OK);
	}

	@GetMapping(value = "/teste/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> teste(@PathVariable("id") int id) {
		return new ResponseEntity<String>("aqui vai o teste", HttpStatus.OK);
	}
}