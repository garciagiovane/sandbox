package com.garciagiovane.cloud.hystrix.poc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class HystrixPoc {

	@GetMapping("/mensagem/{nome}/{id}")
	public ResponseEntity<String> responder(@PathVariable("nome") String nome, @PathVariable("id") int id) {
		return new ResponseEntity<String>(new CadastroCommand(nome, id).execute(), HttpStatus.OK);
	}
}
