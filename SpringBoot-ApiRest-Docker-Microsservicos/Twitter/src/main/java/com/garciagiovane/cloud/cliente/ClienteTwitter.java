package com.garciagiovane.cloud.cliente;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
@RestController
public class ClienteTwitter {
	@Value("${OAuthConsumerKey}")
	private String oAuthConsumerKey;

	@Value("${OAuthConsumerSecret}")
	private String oAuthConsumerSecret;

	@Value("${OAuthAccessToken}")
	private String oAuthAccessToken;

	@Value("${OAuthAccessTokenSecret}")
	private String oAuthAccessTokenSecret;

    @RequestMapping(value = "/twitter/{usuario}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity quantidadeTweets(@PathVariable("usuario") String usuario) {
        Map<String, String> resposta = new HashMap<>();
        Gson gson = new Gson();
        try {
            resposta.put("tweets", String.valueOf(devTwitter().showUser(usuario).getStatusesCount()));
            return ResponseEntity.ok(gson.toJson(resposta));
        } catch (TwitterException errotwitter) {
            resposta.put("mensagem", "usuario nao encontrado");
            return ResponseEntity.badRequest().body(gson.toJson(resposta));
        }
    }

    private Twitter devTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(oAuthConsumerKey)
                .setOAuthConsumerSecret(oAuthConsumerSecret)
                .setOAuthAccessToken(oAuthAccessToken)
                .setOAuthAccessTokenSecret(oAuthAccessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}