package com.garciagiovane.cloud.cliente;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterCommand extends HystrixCommand<String> {
	private String usuario;	
	private String oAuthConsumerKey = System.getenv("OAuthConsumerKey");
	private String oAuthConsumerSecret = System.getenv("OAuthConsumerSecret");
	private String oAuthAccessToken = System.getenv("OAuthAccessToken");
	private String oAuthAccessTokenSecret = System.getenv("OAuthAccessTokenSecret");
	
	public TwitterCommand(String usuario) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.usuario = usuario;
	}

	@Override
	protected String run() throws Exception {
		return "{\"tweets\":\"" + devTwitter().showUser(usuario).getStatusesCount() + "\"}";
	}

	@Override
	protected String getFallback() {
		return "{\"mensagem\":\"usuario nao encontrado\"}";
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
