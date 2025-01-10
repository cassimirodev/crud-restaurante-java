package view;

import controller.CardapioController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Scanner;

public class CardapioMenu {
    private final CardapioController cardapioController;
    private final Scanner scanner;

    public CardapioMenu(EntityManager entityManager) {
        this.cardapioController = new CardapioController(entityManager);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cardápio ---");
            System.out.println("1. Adicionar prato");
            System.out.println("2. Atualizar prato");
            System.out.println("3. Remover prato");
            System.out.println("4. Buscar prato por ID");
            System.out.println("5. Listar todos os pratos");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPrato();
                    break;
                case 2:
                    atualizarPrato();
                    break;
                case 3:
                    removerPrato();
                    break;
                case 4:
                    buscarPratoPorId();
                    break;
                case 5:
                    listarTodosPratos();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarPrato() {
        System.out.print("Digite o nome do prato: ");
        String nomePrato = scanner.nextLine();
        System.out.print("Digite o preço do prato: ");
        BigDecimal preco = scanner.nextBigDecimal();
        scanner.nextLine();
        cardapioController.adicionarPrato(nomePrato, preco);
        System.out.println("Prato adicionado com sucesso.");
    }

    private void atualizarPrato() {
        System.out.print("Digite o ID do prato a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo nome do prato: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite o novo preço do prato: ");
        BigDecimal novoPreco = scanner.nextBigDecimal();
        scanner.nextLine();
        cardapioController.atualizarPrato(id, novoNome, novoPreco);
        System.out.println("Prato atualizado com sucesso.");
    }

    private void removerPrato() {
        System.out.print("Digite o ID do prato a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        cardapioController.removerPrato(id);
        System.out.println("Prato removido com sucesso.");
    }

    private void buscarPratoPorId() {
        System.out.print("Digite o ID do prato: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Prato encontrado: " + CardapioController.buscarPratoPorId(id));
    }

    private void listarTodosPratos() {
        System.out.println("\n--- Exibindo Todos os Pratos ---");
    CardapioController.listarTodosPratos();
    }
}
