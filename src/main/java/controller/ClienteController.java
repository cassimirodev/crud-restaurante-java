package controller;

import jakarta.persistence.EntityManager;
import model.Cliente;
import repository_jpa.ClienteRepository;

import java.util.List;

public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(EntityManager entityManager) {
        this.clienteRepository = new ClienteRepository(entityManager);
    }

    public void adicionarCliente(String nome) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        clienteRepository.salvar(cliente);
    }

    public String buscarClientePorId(int id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente com o ID especificado não encontrado.");
        }
        return String.format("ID: %d | Nome: %s", cliente.getId(), cliente.getNome());
    }

    public void listarTodosClientes() {
        List<Cliente> clientes = clienteRepository.buscarTodos();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            System.out.println("\n--- Lista de Todos os Clientes ---");
            for (Cliente cliente : clientes) {
                System.out.printf("ID: %-5d | Nome: %-20s%n", cliente.getId(), cliente.getNome());
            }
        }
    }


    public void atualizarCliente(int id, String novoNome) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        if (cliente != null) {
            cliente.setNome(novoNome);
            clienteRepository.atualizar(cliente);
        }
    }

    public void removerCliente(int id) {
        clienteRepository.deletar(id);
    }
}
