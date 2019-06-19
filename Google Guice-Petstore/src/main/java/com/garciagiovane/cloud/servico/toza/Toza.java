package com.garciagiovane.cloud.servico.toza;

import com.garciagiovane.cloud.servico.banho.ServicoPet;

public class Toza implements ServicoPet {
    private double valor = 5;
    
    @Override
    public double prepararServico() {
        return valor;
    }

    @Override
    public String descreverServico() {
        return "Toza ";
    }
}
