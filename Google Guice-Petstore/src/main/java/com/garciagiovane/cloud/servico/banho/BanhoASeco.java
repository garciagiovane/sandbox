package com.garciagiovane.cloud.servico.banho;

public class BanhoASeco extends MontagemPacote {
    private final double precoAdicionalServico = 30;

    public BanhoASeco(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String descreverBanho(){
        return "a seco ";
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
