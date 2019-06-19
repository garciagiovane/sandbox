package com.garciagiovane.cloud;

import com.garciagiovane.cloud.modulo.DescricaoOperacao;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import com.garciagiovane.cloud.geradorid.GeradorId;
import com.garciagiovane.cloud.servico.Servico;
import com.garciagiovane.cloud.servico.ServicosPetStore;
import com.garciagiovane.cloud.servico.banho.Banho;
import com.garciagiovane.cloud.servico.banho.BanhoASeco;
import com.garciagiovane.cloud.servico.banho.BanhoMolhado;
import com.garciagiovane.cloud.servico.banho.ComPerfume;
import com.garciagiovane.cloud.servico.banho.SemPerfume;
import com.garciagiovane.cloud.servico.banho.ServicoPet;
import com.garciagiovane.cloud.servico.toza.Toza;
import com.garciagiovane.cloud.servico.toza.TozaCurta;
import com.garciagiovane.cloud.servico.toza.TozaLonga;

@RunWith(MockitoJUnitRunner.class)
public class PetStoreTest {
    @Mock
    private Injector injector;
    private Servico servico;

    @Before
    public void inicializar() {
        MockitoAnnotations.initMocks(this);
        Map<Enum, ServicoPet> servicos = new HashMap<>();
        servicos.put(DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME, new BanhoMolhado(new SemPerfume(new Banho())));
        servicos.put(DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME, new BanhoMolhado(new ComPerfume(new Banho())));
        servicos.put(DescricaoOperacao.BANHO_SECO_SEM_PERFUME, new BanhoASeco(new SemPerfume(new Banho())));
        servicos.put(DescricaoOperacao.BANHO_SECO_COM_PERFUME, new BanhoASeco(new ComPerfume(new Banho())));
        servicos.put(DescricaoOperacao.TOZA_CURTA, new TozaCurta(new Toza()));
        servicos.put(DescricaoOperacao.TOZA_LONGA, new TozaLonga(new Toza()));
        ServicosPetStore servicosPetStore = new ServicosPetStore(servicos);

        when(injector.getInstance(Servico.class)).thenReturn(new Servico(injector, new GeradorId()));
        when(injector.getInstance(ServicosPetStore.class)).thenReturn(servicosPetStore);

        servico = injector.getInstance(Servico.class);
    }

    private void popularLista() {
        servico.cadastrarPet("Mel", "Pinscher", 2);
        servico.cadastrarPet("dog", "Pinscher", 4);
        servico.cadastrarPet("piupiu", "Pinscher", 2);
        servico.cadastrarPet("capitu", "Pinscher", 6);
        servico.cadastrarPet("malaquias", "Pinscher", 2);
        servico.cadastrarPet("josney", "Pinscher", 8);
    }

    private void executarServicosParaOTest() {
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
        servico.executarServicoPet(2, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
        servico.executarServicoPet(4, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
        servico.executarServicoPet(5, DescricaoOperacao.BANHO_SECO_COM_PERFUME);
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME);
        servico.executarServicoPet(1, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
        servico.executarServicoPet(6, DescricaoOperacao.BANHO_MOLHADO_COM__PERFUME);
        servico.executarServicoPet(3, DescricaoOperacao.BANHO_SECO_SEM_PERFUME);
    }

    @Test
    public void testCadastrarPet() {
        assertEquals("Cadastrado com sucesso!", servico.cadastrarPet("Mel", "Pinscher", 2));
    }

    @Test
    public void testExcluirPet() {
        popularLista();
        assertEquals("Excluído com sucesso!", servico.removerPet(3));
    }

    @Test
    public void testBuscarPetPorIdade() {
        popularLista();
        assertNotNull(servico.buscarPorIdade(3));
    }

    @Test
    public void testDarBanhoPet() {
        popularLista();
        assertEquals("Serviço realizado banho sem perfume molhado \nTotal: 25.0", servico.executarServicoPet(1, DescricaoOperacao.BANHO_MOLHADO_SEM_PERFUME));
    }

    @Test(expected = RuntimeException.class)
    public void testErroDarBanhoPet() {
        popularLista();
        servico.executarServicoPet(2, DescricaoOperacao.TESTE_PARA_ERRO);
    }

    @Test
    public void testHistoricoServicos() {
        popularLista();
        executarServicosParaOTest();
        assertTrue(servico.historicoServicos().get(0).descreverServico().equals("banho sem perfume molhado "));
    }

    @Test
    public void testTamanhoTop10() {
        popularLista();
        executarServicosParaOTest();
        assertTrue(servico.top10Pets().size() == 6);
    }

    @Test
    public void testUltimaPosicaoTop10() {
        popularLista();
        executarServicosParaOTest();
        assertTrue(servico.top10Pets().get(5).getNome().equals("josney"));
    }

    @Test
    public void testPrimeiraPosicaoTop10() {
        popularLista();
        executarServicosParaOTest();
        assertTrue(servico.top10Pets().get(0).getNome().equals("piupiu"));
    }
}
