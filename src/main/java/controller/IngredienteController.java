package controller;

import jakarta.persistence.EntityManager;
import model.Ingrediente;
import repository_jpa.IngredienteRepository;

import java.util.List;

public class IngredienteController {

    private static IngredienteRepository ingredienteRepository = null
            ;

    public IngredienteController(EntityManager entityManager) {
        ingredienteRepository = new IngredienteRepository(entityManager);
    }

    public void adicionarIngrediente(String nome, int quantidade) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome);
        ingrediente.setQuantidadeIngrediente(quantidade);
        ingredienteRepository.salvar(ingrediente);
    }

    public String buscarIngredientePorId(int id) {
        Ingrediente ingrediente = ingredienteRepository.buscarPorId(id);
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente com o ID especificado não encontrado.");
        }
        return String.format("ID: %d | Nome: %s | Quantidade: %d",
                ingrediente.getIdIngrediente(), ingrediente.getNome(), ingrediente.getQuantidadeIngrediente());
    }

    public static void listarTodosIngredientes() {
        List<Ingrediente> ingredientes = ingredienteRepository.buscarTodos();
        if (ingredientes.isEmpty()) {
            System.out.println("Nenhum ingrediente encontrado.");
        } else {
            System.out.println("\n--- Lista de Todos os Ingredientes ---");
            for (Ingrediente ingrediente : ingredientes) {
                System.out.printf("ID: %-5d | Nome: %-20s | Quantidade: %-5d%n",
                        ingrediente.getIdIngrediente(), ingrediente.getNome(), ingrediente.getQuantidadeIngrediente());
            }
        }
    }


    public void atualizarIngrediente(int id, String novoNome, int novaQuantidade) {
        Ingrediente ingrediente = ingredienteRepository.buscarPorId(id);
        if (ingrediente != null) {
            ingrediente.setNome(novoNome);
            ingrediente.setQuantidadeIngrediente(novaQuantidade);
            ingredienteRepository.atualizar(ingrediente);
        }
    }

    public void removerIngrediente(int id) {
        ingredienteRepository.deletar(id);
    }
}
