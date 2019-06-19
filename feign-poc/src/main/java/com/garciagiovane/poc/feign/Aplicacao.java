package com.garciagiovane.poc.feign;

import feign.Feign;

public class Aplicacao {
	
	public static void main(String[] args) {
		String url = "https://api.github.com";
		Teste teste = Feign.builder().target(Teste.class, url);
		System.out.println(teste.requisicao("garciagiovane"));
	}
}