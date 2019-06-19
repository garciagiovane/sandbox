package com.garciagiovane.cloud.cliente;

import com.google.gson.Gson;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Github {
    @Value("${oAuth2Token}")
    private String oAuth2Token;

    @RequestMapping(value = "/github/{usuario}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity quantidadeRepositorios(@PathVariable("usuario") String usuario) {
        Gson gson = new Gson();
        Map<String, String> resposta = new HashMap<>();
        try {
            resposta.put("repositorios", doRequest(usuario));
            return ResponseEntity.ok(gson.toJson(resposta));
        } catch (IOException erro) {
            resposta.put("mensagem", "usuario nao encontrado");
            return ResponseEntity.badRequest().body(gson.toJson(resposta));
        }
    }

    private String doRequest(String usuarioGithub) throws IOException {
        GitHubClient githubClient = new GitHubClient();
        githubClient.setOAuth2Token(oAuth2Token);
        RepositoryService repositorios = new RepositoryService();
        return String.valueOf(repositorios.getRepositories(usuarioGithub).size());
    }
}