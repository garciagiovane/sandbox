package com.garciagiovane.poc.main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteRest {
	@RequestMapping(value = "/mensagem")
	@ResponseBody
	public ResponseEntity<String> responder() {
		return new ResponseEntity<String>("deu bom na porta 9001", HttpStatus.OK);
	}
}