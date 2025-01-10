package controller;

import jakarta.persistence.EntityManager;
import model.Mesa;
import repository_jpa.MesaRepository;

import java.util.List;

public class MesaController {

    private static MesaRepository mesaRepository = null;

    public MesaController(EntityManager entityManager) {
        mesaRepository = new MesaRepository(entityManager);
    }

    public void adicionarMesa(int numeroMesa, int qtdCadeiras) {
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(numeroMesa);
        mesa.setQtdCadeiras(qtdCadeiras);
        mesaRepository.salvar(mesa);
    }

    public String buscarMesaPorId(int id) {
        Mesa mesa = mesaRepository.buscarPorId(id);
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa com o ID especificado não encontrada.");
        }
        return String.format("ID: %d | Número: %d | Cadeiras: %d | Status: %s",
                mesa.getIdMesa(), mesa.getNumeroMesa(), mesa.getQtdCadeiras(), mesa.getStatus());
    }

    public static void listarTodasMesas() {
        List<Mesa> mesas = mesaRepository.buscarTodos();
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa encontrada.");
        } else {
            System.out.println("\n--- Lista de Todas as Mesas ---");
            for (Mesa mesa : mesas) {
                System.out.printf("ID: %-5d | Número: %-5d | Cadeiras: %-5d | Status: %-15s%n",
                        mesa.getIdMesa(), mesa.getNumeroMesa(), mesa.getQtdCadeiras(), mesa.getStatus());
            }
        }
    }


    public void atualizarMesa(int id, int novoNumero, int novaQtdCadeiras) {
        Mesa mesa = mesaRepository.buscarPorId(id);
        if (mesa != null) {
            mesa.setNumeroMesa(novoNumero);
            mesa.setQtdCadeiras(novaQtdCadeiras);
            mesaRepository.atualizar(mesa);
        }
    }

    public void removerMesa(int id) {
        mesaRepository.deletar(id);
    }
}
