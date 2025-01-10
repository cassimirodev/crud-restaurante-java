package view;

import controller.ClienteController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ClienteMenu {
    private final ClienteController clienteController;
    private final Scanner scanner;

    public ClienteMenu(EntityManager entityManager) {
        this.clienteController = new ClienteController(entityManager);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Buscar cliente por ID");
            System.out.println("3. Listar todos os clientes");
            System.out.println("4. Atualizar cliente");
            System.out.println("5. Remover cliente");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    buscarClientePorId();
                    break;
                case 3:
                    listarTodosClientes();
                    break;
                case 4:
                    atualizarCliente();
                    break;
                case 5:
                    removerCliente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        clienteController.adicionarCliente(nome);
        System.out.println("Cliente adicionado com sucesso.");
    }

    private void buscarClientePorId() {
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cliente encontrado: " + clienteController.buscarClientePorId(id));
    }

    private void listarTodosClientes() {
        System.out.println("Lista de todos os clientes:");
        clienteController.listarTodosClientes();
    }

    private void atualizarCliente() {
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo nome do cliente: ");
        String novoNome = scanner.nextLine();
        clienteController.atualizarCliente(id, novoNome);
        System.out.println("Cliente atualizado com sucesso.");
    }

    private void removerCliente() {
        System.out.print("Digite o ID do cliente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        clienteController.removerCliente(id);
        System.out.println("Cliente removido com sucesso.");
    }
}
