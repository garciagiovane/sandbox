package com.garciagiovane.cloud.servico.toza;

import com.garciagiovane.cloud.servico.banho.MontagemPacote;
import com.garciagiovane.cloud.servico.banho.ServicoPet;

public class TozaLonga extends MontagemPacote {
    private final double precoAdicionalServico = 15;

    public TozaLonga(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String descreverToza(){
        return "Longa";
    }

    @Override
    public double prepararServico() {
        return super.prepararServico() + precoAdicionalServico;
    }

    @Override
    public String descreverServico() {
        return super.descreverServico() + descreverToza();
    }
}
