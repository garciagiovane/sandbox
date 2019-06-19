package com.garciagiovane.cloud.twitter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.garciagiovane.cloud.cliente.ClienteTwitter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TwitterApplicationTests {

	@Autowired
	private ClienteTwitter clienteTwitter;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void testContext() throws Exception {
    	assertThat(clienteTwitter).isNotNull();
    }	

    @Test
    public void testResultadoOK() throws Exception {
    	assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/twitter/garciagiovane", String.class)).contains("{\"tweets\":\"883\"}");
    }

    @Test
	public void testRespostaErro() {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/twitter/garciagiovaneadfgsfgsd", String.class)).contains("{\"mensagem\":\"usuario nao encontrado\"}");
	}
}