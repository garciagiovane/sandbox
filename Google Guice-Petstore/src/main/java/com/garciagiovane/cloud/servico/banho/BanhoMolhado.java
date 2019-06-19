package com.garciagiovane.cloud.servico.banho;

public class BanhoMolhado extends MontagemPacote {
    private final double precoAdicionalServico = 20;

    public BanhoMolhado(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String descreverBanho(){
        return "molhado ";
    }

    @Override
    public double prepararServico() {
        return super.prepararServico() + precoAdicionalServico;
    }

    @Override
    public String descreverServico() {
        return super.descreverServico() + descreverBanho();
    }
}
