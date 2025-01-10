package view;

import controller.IngredienteController;
import jakarta.persistence.EntityManager;
import java.util.Scanner;

public class IngredienteMenu {
    private final IngredienteController ingredienteController;
    private final Scanner scanner;

    public IngredienteMenu(EntityManager entityManager) {
        this.ingredienteController = new IngredienteController(entityManager);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Ingrediente ---");
            System.out.println("1. Adicionar ingrediente");
            System.out.println("2. Buscar ingrediente por ID");
            System.out.println("3. Listar todos os ingredientes");
            System.out.println("4. Atualizar ingrediente");
            System.out.println("5. Remover ingrediente");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarIngrediente();
                    break;
                case 2:
                    buscarIngredientePorId();
                    break;
                case 3:
                    listarTodosIngredientes();
                    break;
                case 4:
                    atualizarIngrediente();
                    break;
                case 5:
                    removerIngrediente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarIngrediente() {
        System.out.print("Digite o nome do ingrediente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade do ingrediente: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        ingredienteController.adicionarIngrediente(nome, quantidade);
        System.out.println("Ingrediente adicionado com sucesso.");
    }

    private void buscarIngredientePorId() {
        System.out.print("Digite o ID do ingrediente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrediente encontrado: " + ingredienteController.buscarIngredientePorId(id));
    }

    private void listarTodosIngredientes() {
        System.out.println("Lista de todos os ingredientes:");
        IngredienteController.listarTodosIngredientes();
    }

    private void atualizarIngrediente() {
        System.out.print("Digite o ID do ingrediente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo nome do ingrediente: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a nova quantidade do ingrediente: ");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine();
        ingredienteController.atualizarIngrediente(id, novoNome, novaQuantidade);
        System.out.println("Ingrediente atualizado com sucesso.");
    }

    private void removerIngrediente() {
        System.out.print("Digite o ID do ingrediente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ingredienteController.removerIngrediente(id);
        System.out.println("Ingrediente removido com sucesso.");
    }
}
