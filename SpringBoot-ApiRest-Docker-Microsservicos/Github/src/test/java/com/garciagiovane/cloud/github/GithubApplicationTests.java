package com.garciagiovane.cloud.github;

import com.garciagiovane.cloud.cliente.Github;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Github.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GithubApplicationTests {

	@Autowired
	private Github github;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void testContext() throws Exception {
    	assertThat(github).isNotNull();
    }	

    @Test
    public void testResultadoOK() throws Exception {
    	assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/github/garciagiovane", String.class)).contains("{\"repositorios\":\"10\"}");
    }

    @Test
	public void testRespostaErro() {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/github/garciagiovaneadfgsfgsd", String.class)).contains("{\"mensagem\":\"usuario nao encontrado\"}");
	}
} 