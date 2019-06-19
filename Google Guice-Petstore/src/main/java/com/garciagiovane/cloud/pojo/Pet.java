package com.garciagiovane.cloud.pojo;

import com.garciagiovane.cloud.servico.banho.ServicoPet;

import java.util.List;

public class Pet {
	private int id;
	private int idade;
	private String nome;
	private String raca;
	private double valorGasto;
	private List<ServicoPet> servicosRealizados;

	public Pet(int id, int idade, String nome, String raca, List<ServicoPet> servicosRealizados) {
		this.id = id;
		this.idade = idade;
		this.nome = nome;
		this.raca = raca;
		this.servicosRealizados = servicosRealizados;
	}

	public List<ServicoPet> getServicosRealizados() {
		return servicosRealizados;
	}
	public void setServicosRealizados(List<ServicoPet> servicosRealizados) {
		this.servicosRealizados = servicosRealizados;
	}
	public double getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", idade=" + idade +
				", nome='" + nome + '\'' +
				", raca='" + raca + '\'' +
				", valorGasto=" + valorGasto +
				", servicosRealizados=" + servicosRealizados +
				'}';
	}
}
