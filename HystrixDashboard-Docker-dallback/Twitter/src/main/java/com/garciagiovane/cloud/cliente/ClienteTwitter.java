package com.garciagiovane.cloud.cliente;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteTwitter {
	
	@RequestMapping(value = "/twitter/{usuario}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<String> retornarQuantidadeTweets(@PathVariable("usuario") String usuario) {
		return ResponseEntity.ok(new TwitterCommand(usuario).execute());
    }
}