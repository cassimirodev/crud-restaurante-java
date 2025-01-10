package repository_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Mesa;

import java.util.List;

public class MesaRepository {

    private final EntityManager entityManager;

    public MesaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Mesa mesa) {
        entityManager.getTransaction().begin();
        entityManager.persist(mesa);
        entityManager.getTransaction().commit();
    }

    public Mesa buscarPorId(int id) {
        return entityManager.find(Mesa.class, id);
    }

    public List<Mesa> buscarTodos() {
        TypedQuery<Mesa> query = entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class);
        return query.getResultList();
    }

    public void atualizar(Mesa mesa) {
        entityManager.getTransaction().begin();
        entityManager.merge(mesa);
        entityManager.getTransaction().commit();
    }

    public void deletar(int id) {
        Mesa mesa = buscarPorId(id);
        if (mesa != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(mesa);
            entityManager.getTransaction().commit();
        }
    }
}
