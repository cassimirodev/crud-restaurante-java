package interfaces;

import model.Cardapio;
import java.math.BigDecimal;
import java.util.List;

public interface CardapioControllerInterface {
    Cardapio adicionarPrato(String nomePrato, BigDecimal preco);
    Cardapio atualizarPrato(int id, String novoNome, BigDecimal novoPreco);
    void removerPrato(int id);
    Cardapio buscarPratoPorId(int id);
    List<Cardapio> listarTodosPratos();
}
