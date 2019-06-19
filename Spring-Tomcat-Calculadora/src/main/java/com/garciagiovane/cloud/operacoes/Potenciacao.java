package com.garciagiovane.cloud.operacoes;

public class Potenciacao implements  Operacao {
	private double a;
	private double b;

	public Potenciacao(double a, double b){
		this.a = a;
		this.b = b;
	}

	@Override
	public double calcular() {
		return Math.pow(a,b);
	}

	@Override
	public String toString() {
		return "Potenciacao [a=" + a + ", b=" + b + "]";
	}
}
