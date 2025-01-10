package controller;

import jakarta.persistence.EntityManager;
import model.Cardapio;
import repository_jpa.CardapioRepository;

import java.math.BigDecimal;
import java.util.List;

public class CardapioController {

    private static CardapioRepository repository = null;

    public CardapioController(EntityManager entityManager) {
        this.repository = new CardapioRepository(entityManager);
    }

    public Cardapio adicionarPrato(String nomePrato, BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço do prato deve ser maior que zero.");
        }

        Cardapio cardapio = new Cardapio();
        cardapio.setNome_prato(nomePrato);
        cardapio.setPreco_prato(preco);

        return repository.salvar(cardapio);
    }

    public Cardapio atualizarPrato(int id, String novoNome, BigDecimal novoPreco) {
        Cardapio cardapio = repository.buscarPorId(id);
        if (cardapio == null) {
            throw new IllegalArgumentException("Prato com o ID especificado não encontrado.");
        }

        if (novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço do prato deve ser maior que zero.");
        }

        cardapio.setNome_prato(novoNome);
        cardapio.setPreco_prato(novoPreco);

        return repository.atualizar(cardapio);
    }

    public void removerPrato(int id) {
        Cardapio cardapio = repository.buscarPorId(id);
        if (cardapio == null) {
            throw new IllegalArgumentException("Prato com o ID especificado não encontrado.");
        }
        repository.deletar(id);
    }

    public static String buscarPratoPorId(int id) {
        Cardapio prato = repository.buscarPorId(id);
        if (prato == null) {
            throw new IllegalArgumentException("Prato com o ID especificado não encontrado.");
        }
        return String.format("ID: %d | Nome: %s | Preço: %.2f",
                prato.getId_prato(), prato.getNome_prato(), prato.getPreco_prato());
    }

    public static void listarTodosPratos() {
        List<Cardapio> pratos = repository.buscarTodos();
        if (pratos.isEmpty()) {
            System.out.println("Nenhum prato encontrado.");
        } else {
            System.out.println("\n--- Lista de Todos os Pratos ---");
            for (Cardapio prato : pratos) {
                System.out.printf("Prato ID: %d | Nome: %-20s | Preço: %.2f%n",
                        prato.getId_prato(), prato.getNome_prato(), prato.getPreco_prato());
            }
        }
    }

}