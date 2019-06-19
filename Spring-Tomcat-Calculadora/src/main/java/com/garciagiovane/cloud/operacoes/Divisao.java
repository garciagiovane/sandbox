package com.garciagiovane.cloud.operacoes;

public class Divisao implements Operacao {
	private double a;
	private double b;

	public Divisao(double a, double b){
		this.a = a;
		this.b = b;
	}
	
    @Override
    public double calcular() {
        return a / b;
    }

	@Override
	public String toString() {
		return "Divisao [a=" + a + ", b=" + b + "]";
	}
}
