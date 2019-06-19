package com.garciagiovane.cloud.operacoes;

public class Subtracao implements Operacao{
	private double a;
	private double b;

	public Subtracao(double a, double b){
		this.a = a;
		this.b = b;
	}

	@Override
	public double calcular() {
		return a - b;
	}

	@Override
	public String toString() {
		return "Subtracao [a=" + a + ", b=" + b + "]";
	}
}
