package com.garciagiovane.cloud.servico;

import com.garciagiovane.cloud.geradorid.GeradorId;
import com.garciagiovane.cloud.pojo.Pet;
import com.garciagiovane.cloud.servico.banho.*;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class Servico {
    private Injector injector;
    private GeradorId geradorId;
    private List<Pet> pets = new ArrayList<>();
    private List<ServicoPet> servicosRealizados = new ArrayList<>();

    @Inject
    public Servico(Injector injector, GeradorId geradorId) {
        this.injector = injector;
        this.geradorId = geradorId;
    }

    public String cadastrarPet(String nome, String raca, int idade) {
        return (gravar(new Pet(geradorId.gerarId(), idade, nome, raca, new ArrayList<>())) != null) ? "Cadastrado com sucesso!" : "Erro ao cadastrar!";
    }

    public String removerPet(int id) {
        return (excluir(id)) ? "Excluído com sucesso!" : "Erro ao excluir!";
    }

    public List<Pet> buscarPorIdade(int idade) {
        return Collections.unmodifiableList(this.pets.stream().filter(p -> p.getIdade() == idade).collect(Collectors.toList()));
    }

    private Pet buscarPetPorId(int id) {
        return pets.stream().filter(pet -> pet.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Pet não encontrado!"));
    }

    private void adicionarServicoAoPet(int id, ServicoPet servicoPet) {
        alterarRegisto().forEach(p -> {
            if (p.getId() == id) {
                List<ServicoPet> servicosDoPet;
                p.setValorGasto(p.getValorGasto() + servicoPet.prepararServico());
                servicosDoPet = p.getServicosRealizados();
                servicosDoPet.add(servicoPet);
                p.setServicosRealizados(servicosDoPet);
            }
        });
    }

    public String executarServicoPet(int id, Enum codServico) {
        ServicoPet servicoPet = servicoComprado(codServico);
        servicosRealizados.add(servicoPet);
        adicionarServicoAoPet(buscarPetPorId(id).getId(), servicoPet);
        return "Serviço realizado " + servicoPet.descreverServico() + "\nTotal: " + servicoPet.prepararServico();
    }

    private ServicoPet servicoComprado(Enum codServico) {
        ServicosPetStore servicosPetStore = injector.getInstance(ServicosPetStore.class);
        return servicosPetStore.buscarServicoPorCodigo(codServico);
    }

    public List<ServicoPet> historicoServicos() {
        return Collections.unmodifiableList(servicosRealizados);
    }

    public List<Pet> top10Pets() {
        return Collections.unmodifiableList(pets.stream().filter(p -> p.getValorGasto() > 0).sorted(Comparator.comparing(Pet::getValorGasto).reversed()).limit(10).collect(Collectors.toList()));
    }

    private Pet gravar(Pet pet) {
        if (pets.add(pet)) {
            return pet;
        }
        throw new RuntimeException("Erro ao gravar Pet");
    }


    private boolean excluir(int id) {
        return (pets.remove(buscarPetPorId(id))) ? true : false;
    }

    private List<Pet> alterarRegisto() {
        return pets;
    }
}