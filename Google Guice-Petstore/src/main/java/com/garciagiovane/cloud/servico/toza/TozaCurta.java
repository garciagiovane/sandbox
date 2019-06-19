package com.garciagiovane.cloud.servico.toza;

import com.garciagiovane.cloud.servico.banho.MontagemPacote;
import com.garciagiovane.cloud.servico.banho.ServicoPet;

public class TozaCurta extends MontagemPacote {
    private final double precoAdicionalServico = 20;

    public TozaCurta(ServicoPet servicoPet) {
        super(servicoPet);
    }

    private String descreverToza(){
        return "curta ";
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
