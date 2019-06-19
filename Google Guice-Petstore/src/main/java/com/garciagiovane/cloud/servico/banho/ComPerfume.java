package com.garciagiovane.cloud.servico.banho;

public class ComPerfume extends MontagemPacote {
    private final double precoAdicionalServico = 10;

    public ComPerfume(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String comPerfume(){
        return "com perfume ";
    }

    @Override
    public double prepararServico() {
        return super.prepararServico() + precoAdicionalServico;
    }

    @Override
    public String descreverServico() {
        return super.descreverServico() + comPerfume();
    }
}
