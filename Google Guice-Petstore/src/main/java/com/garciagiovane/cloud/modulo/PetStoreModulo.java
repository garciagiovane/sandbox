package com.garciagiovane.cloud.modulo;

import com.garciagiovane.cloud.servico.banho.Banho;
import com.garciagiovane.cloud.servico.banho.BanhoASeco;
import com.garciagiovane.cloud.servico.banho.BanhoMolhado;
import com.garciagiovane.cloud.servico.banho.ComPerfume;
import com.garciagiovane.cloud.servico.banho.SemPerfume;
import com.garciagiovane.cloud.servico.banho.ServicoPet;
import com.garciagiovane.cloud.servico.toza.Toza;
import com.garciagiovane.cloud.servico.toza.TozaCurta;
import com.garciagiovane.cloud.servico.toza.TozaLonga;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class PetStoreModulo extends AbstractModule{
	@Override
	protected void configure() {
		MapBinder<Enum, ServicoPet> servicos = MapBinder.newMapBinder(binder(), Enum.class, ServicoPet.class);
		servicos.addBinding(DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME).toInstance(new BanhoMolhado(new SemPerfume(new Banho())));
		servicos.addBinding(DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME).toInstance(new BanhoMolhado(new ComPerfume(new Banho())));
		servicos.addBinding(DescricaoOperacao.BANHO_SECO_SEM_PERFUME).toInstance(new BanhoASeco(new SemPerfume(new Banho())));
		servicos.addBinding(DescricaoOperacao.BANHO_SECO_COM_PERFUME).toInstance(new BanhoASeco(new ComPerfume(new Banho())));
		servicos.addBinding(DescricaoOperacao.TOZA_CURTA).toInstance(new TozaCurta(new Toza()));
		servicos.addBinding(DescricaoOperacao.TOZA_LONGA).toInstance(new TozaLonga(new Toza()));
	}
}
