package com.garciagiovane.cloud.cliente;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {

    @RequestMapping(value = "/api/twitter/{usuarioTwitter}/github/{usuarioGithub}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<String> consulta(@PathVariable("usuarioTwitter") String usuarioTwitter, @PathVariable("usuarioGithub") String usuarioGithub) {
        List<Object> resposta = new ArrayList<>();
        resposta.add(new JsonParser().parse(consultaTwitter(usuarioTwitter)).getAsJsonObject());
        resposta.add((new JsonParser().parse(consultaGithub(usuarioGithub)).getAsJsonObject()));
        return ResponseEntity.ok(new Gson().toJson(resposta));
    }

    private String consultaTwitter(String usuarioTwitter) {
        String url = "http://twitter:8080/twitter/" + usuarioTwitter;
        return new TwitterCommand(url).execute();
    }

    private String consultaGithub(String usuarioGithub) {
        String url = "http://github:8080/github/" + usuarioGithub;
        return new GithubCommand(url).execute();
    }
}