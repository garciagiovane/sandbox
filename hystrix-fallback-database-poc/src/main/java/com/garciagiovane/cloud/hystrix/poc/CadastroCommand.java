package com.garciagiovane.cloud.hystrix.poc;

import com.garciagiovane.cloud.dao.TesteDAO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CadastroCommand extends HystrixCommand<String>{
	private String nome;
	private int id;
	
	public CadastroCommand(String nome, int id) {
		super(HystrixCommandGroupKey.Factory.asKey("cadastro"));
		this.nome = nome;
		this.id = id;
	}

	@Override
	protected String run() throws Exception {
		new TesteDAO().cadastrar(nome, id);
		return "Cadastro realizado com sucesso!";
	}

	@Override
	protected String getFallback() {
		return "Erro no cadastro";
	}
}
