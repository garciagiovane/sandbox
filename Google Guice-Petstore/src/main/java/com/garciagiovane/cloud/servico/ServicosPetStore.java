package com.garciagiovane.cloud.servico;

import java.util.*;
import com.garciagiovane.cloud.servico.banho.ServicoPet;
import com.google.inject.Inject;

public class ServicosPetStore {
    private Map<Enum, ServicoPet> servicos;

    @Inject
    public ServicosPetStore(Map<Enum, ServicoPet> servicos) {
        this.servicos = servicos;
    }

    public ServicoPet buscarServicoPorCodigo(Enum codigoServico) {
        if (servicos.containsKey(codigoServico)) {
            return servicos.get(codigoServico);
        } else {
            throw new RuntimeException("Servico não encontrado");
        }
    }
}
