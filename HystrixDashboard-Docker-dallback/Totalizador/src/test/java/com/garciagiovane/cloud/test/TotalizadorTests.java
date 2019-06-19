package com.garciagiovane.cloud.test;

import com.garciagiovane.cloud.cliente.GithubCommand;
import com.garciagiovane.cloud.cliente.TwitterCommand;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TotalizadorTests {
	@Test
	public void testTotalizadorGithub() {
		assertEquals("{\"mensagem\":\"usuário não encontrado\"}", new GithubCommand("http://localhost:8082/github/garciagiovane").execute());
	}
	
	@Test
	public void testTotalizadorTwitter() {
		assertEquals("{\"mensagem\":\"usuário não encontrado\"}", new TwitterCommand("http://localhost:8083/twitter/garciagiovane").execute());
	}
}
