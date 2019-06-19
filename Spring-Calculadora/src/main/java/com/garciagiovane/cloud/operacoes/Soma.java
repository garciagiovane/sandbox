package com.garciagiovane.cloud.operacoes;

public class Soma implements Operacao{
	private double a;
	private double b;

	public Soma(double a, double b){
		this.a = a;
		this.b = b;
	}
	
    @Override
    public double calcular() {
        return a + b;
    }

	@Override
	public String toString() {
		return "Soma [a=" + a + ", b=" + b + "]";
	}
}
