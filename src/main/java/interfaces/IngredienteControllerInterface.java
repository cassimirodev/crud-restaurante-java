package interfaces;

import model.Ingrediente;
import java.util.List;

public interface IngredienteControllerInterface {
    void adicionarIngrediente(String nome, int quantidade);
    Ingrediente buscarIngredientePorId(int id);
    List<Ingrediente> listarTodosIngredientes();
    void atualizarIngrediente(int id, String novoNome, int novaQuantidade);
    void removerIngrediente(int id);
}
