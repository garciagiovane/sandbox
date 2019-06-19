package com.garciagiovane.cloud.cliente;

import java.io.IOException;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GithubCommand extends HystrixCommand<String> {
	private String usuario;	
	private String oAuth2Token = System.getenv("oAuth2Token");

	protected GithubCommand(String usuario) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.usuario = usuario;
	}

	@Override
	protected String run() throws Exception {
		return "{\"repositorios\":\"" + doRequest(usuario) + "\"}";
	}

	private String doRequest(String usuario) throws IOException {
		GitHubClient githubClient = new GitHubClient();
		githubClient.setOAuth2Token(oAuth2Token);
		RepositoryService repositorios = new RepositoryService();
		return String.valueOf(repositorios.getRepositories(usuario).size());
	}

	@Override
	protected String getFallback() {
		return "{\"mensagem\":\"usuario nao encontrado\"}";
	}
}
