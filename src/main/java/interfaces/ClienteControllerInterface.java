package interfaces;

import model.Cliente;
import java.util.List;

public interface ClienteControllerInterface {
    void adicionarCliente(String nome);
    Cliente buscarClientePorId(int id);
    List<Cliente> listarTodosClientes();
    void atualizarCliente(int id, String novoNome);
    void removerCliente(int id);
}
