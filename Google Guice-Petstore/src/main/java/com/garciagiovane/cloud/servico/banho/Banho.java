package com.garciagiovane.cloud.servico.banho;

public class Banho implements ServicoPet {
    private double preco = 0;
    
    @Override
    public double prepararServico() {
        return preco;
    }

    @Override
    public String descreverServico() {
        return "banho ";
    }
}
