package view;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner;
    private final EntityManager entityManager;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.entityManager = Persistence.createEntityManagerFactory("SistemaRestaurantePU").createEntityManager();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cardápio");
            System.out.println("2. Cliente");
            System.out.println("3. Ingredientes");
            System.out.println("4. Mesa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    new CardapioMenu(entityManager).exibirMenu();
                    break;
                case 2:
                    new ClienteMenu(entityManager).exibirMenu();
                    break;
                case 3:
                    new IngredienteMenu(entityManager).exibirMenu();
                    break;
                case 4:
                    new MesaMenu(entityManager).exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        new MenuPrincipal().exibirMenu();
    }
}
