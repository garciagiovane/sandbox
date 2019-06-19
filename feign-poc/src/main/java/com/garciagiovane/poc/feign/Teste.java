package com.garciagiovane.poc.feign;

import feign.Param;
import feign.RequestLine;

public interface Teste {
	@RequestLine("GET /repos/{user}/cadastro_alunos")
	String requisicao(@Param("user") String user);
}
