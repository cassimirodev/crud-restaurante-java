package repository_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Cliente;

import java.util.List;

public class ClienteRepository {

    private final EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente buscarPorId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

    public void atualizar(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void deletar(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }
    }
}
