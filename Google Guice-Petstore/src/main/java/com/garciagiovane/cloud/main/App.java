package com.garciagiovane.cloud.main;

import com.garciagiovane.cloud.modulo.DescricaoOperacao;
import com.garciagiovane.cloud.modulo.PetStoreModulo;
import com.garciagiovane.cloud.servico.Servico;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PetStoreModulo());
		Servico servico = injector.getInstance(Servico.class);

		servico.cadastrarPet("mel", "pinscher", 2);
		servico.cadastrarPet("mel", "pinscher", 2);
		servico.cadastrarPet("mel", "pinscher", 2);
		servico.cadastrarPet("Preta", "vira-lata", 5);
		servico.cadastrarPet("mancha", "gato ciames", 2);
		servico.cadastrarPet("alemão", "pastor", 1);
		servico.cadastrarPet("horse", "puro sangue", 3);
		servico.cadastrarPet("miau", "piupiu", 5);
		servico.cadastrarPet("dog", "não sei", 11);
		servico.cadastrarPet("kat", "gatuno", 15);
		servico.cadastrarPet("pig", "porco da india", 16);

		servico.executarServicoPet(2, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
		servico.executarServicoPet(1, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
		servico.executarServicoPet(2, DescricaoOperacao.BANHO_SECO_COM_PERFUME);
		servico.executarServicoPet(3, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
		servico.executarServicoPet(2, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
		servico.executarServicoPet(4, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
		servico.executarServicoPet(2, DescricaoOperacao.BANHO_SECO_COM_PERFUME);
		servico.executarServicoPet(5, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
		servico.executarServicoPet(2, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
		servico.executarServicoPet(6, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
		servico.executarServicoPet(10, DescricaoOperacao.TOZA_CURTA);
		servico.executarServicoPet(10, DescricaoOperacao.TOZA_CURTA);
		servico.executarServicoPet(10, DescricaoOperacao.TOZA_LONGA);
		servico.executarServicoPet(10, DescricaoOperacao.TOZA_CURTA);

        System.out.println("\nHistórico de serviços");
		servico.historicoServicos().forEach( s -> System.out.println(s.descreverServico()));

        System.out.println("\nTop 10 pets");
		servico.top10Pets().forEach(p -> System.out.println("Pet: " + p.getNome() + ", valor gasto: " + p.getValorGasto()));
	}
}