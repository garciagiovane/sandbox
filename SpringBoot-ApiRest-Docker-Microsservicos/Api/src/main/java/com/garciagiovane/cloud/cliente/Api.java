package com.garciagiovane.cloud.cliente;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class Api {

    @RequestMapping(value = "/api/twitter/{usuarioTwitter}/github/{usuarioGithub}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity consulta(@PathVariable("usuarioTwitter") String usuarioTwitter, @PathVariable("usuarioGithub") String usuarioGithub) {
        List<Object> resposta = new ArrayList<>();
        resposta.add(new JsonParser().parse(consultaTwitter(usuarioTwitter)).getAsJsonObject());
        resposta.add((new JsonParser().parse(consultaGithub(usuarioGithub)).getAsJsonObject()));
        return ResponseEntity.ok(new Gson().toJson(resposta));
    }

    private String consultaTwitter(String usuarioTwitter) {
        String urlConsulta = "http://twitter:8080/twitter/" + usuarioTwitter;
        return request(urlConsulta);
    }

    private String consultaGithub(String usuarioGithub) {
        String urlConsulta = "http://github:8080/github/" + usuarioGithub;
        return request(urlConsulta);
    }

    private String request(String urlConsulta) {
        try {
            return new RestTemplate().getForObject(urlConsulta, String.class);
        } catch (Exception erro){
            return "{\"mensagem\":\"usuario nao encontrado\"}";
        }
    }
}