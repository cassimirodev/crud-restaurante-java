package view;

import controller.MesaController;
import jakarta.persistence.EntityManager;
import java.util.Scanner;

public class MesaMenu {
    private final MesaController mesaController;
    private final Scanner scanner;

    public MesaMenu(EntityManager entityManager) {
        this.mesaController = new MesaController(entityManager);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Mesa ---");
            System.out.println("1. Adicionar mesa");
            System.out.println("2. Buscar mesa por ID");
            System.out.println("3. Listar todas as mesas");
            System.out.println("4. Atualizar mesa");
            System.out.println("5. Remover mesa");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMesa();
                    break;
                case 2:
                    buscarMesaPorId();
                    break;
                case 3:
                    listarTodasAsMesas();
                    break;
                case 4:
                    atualizarMesa();
                    break;
                case 5:
                    removerMesa();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarMesa() {
        System.out.print("Digite o número da mesa: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a quantidade de lugares: ");
        int quantidadeLugares = scanner.nextInt();
        scanner.nextLine();
        mesaController.adicionarMesa(numero, quantidadeLugares);
        System.out.println("Mesa adicionada com sucesso.");
    }

    private void buscarMesaPorId() {
        System.out.print("Digite o ID da mesa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mesa encontrada: " + mesaController.buscarMesaPorId(id));
    }

    private void listarTodasAsMesas() {
        System.out.println("Lista de todas as mesas:");
        MesaController.listarTodasMesas();
    }

    private void atualizarMesa() {
        System.out.print("Digite o ID da mesa a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo número da mesa: ");
        int novoNumero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a nova quantidade de lugares: ");
        int novaQuantidadeLugares = scanner.nextInt();
        scanner.nextLine();
        mesaController.atualizarMesa(id, novoNumero, novaQuantidadeLugares);
        System.out.println("Mesa atualizada com sucesso.");
    }

    private void removerMesa() {
        System.out.print("Digite o ID da mesa a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        mesaController.removerMesa(id);
        System.out.println("Mesa removida com sucesso.");
    }
}
