package com.garciagiovane.cloud.operacoes;

public class Multiplicacao implements Operacao{
	private double a;
	private double b;

	public Multiplicacao(double a, double b){
		this.a = a;
		this.b = b;
	}

	@Override
	public double calcular() {
		return a * b;
	}

	@Override
	public String toString() {
		return "Multiplicacao [a=" + a + ", b=" + b + "]";
	}
}
