package com.garciagiovane.cloud.servico.banho;

public abstract class MontagemPacote implements ServicoPet {
    private ServicoPet servicoPet;

    public MontagemPacote(ServicoPet servicoPet){
        this.servicoPet = servicoPet;
    }

    @Override
    public double prepararServico() {
        return servicoPet.prepararServico();
    }

    @Override
    public String descreverServico() {
        return servicoPet.descreverServico();
    }
}
