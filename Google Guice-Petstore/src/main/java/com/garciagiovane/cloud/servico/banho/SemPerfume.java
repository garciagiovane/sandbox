package com.garciagiovane.cloud.servico.banho;

public class SemPerfume extends MontagemPacote {
    private final double precoAdicionalServico = 5;

    public SemPerfume(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String semPerfume(){
        return "sem perfume ";
    }

    @Override
    public double prepararServico() {
        return super.prepararServico() + precoAdicionalServico;
    }

    @Override
    public String descreverServico() {
        return super.descreverServico() + semPerfume();
    }
}
