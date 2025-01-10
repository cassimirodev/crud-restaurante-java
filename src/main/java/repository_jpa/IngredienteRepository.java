package repository_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Ingrediente;

import java.util.List;

public class IngredienteRepository {

    private final EntityManager entityManager;

    public IngredienteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Ingrediente ingrediente) {
        entityManager.getTransaction().begin();
        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();
    }

    public Ingrediente buscarPorId(int id) {
        return entityManager.find(Ingrediente.class, id);
    }

    public List<Ingrediente> buscarTodos() {
        TypedQuery<Ingrediente> query = entityManager.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class);
        return query.getResultList();
    }

    public void atualizar(Ingrediente ingrediente) {
        entityManager.getTransaction().begin();
        entityManager.merge(ingrediente);
        entityManager.getTransaction().commit();
    }

    public void deletar(int id) {
        Ingrediente ingrediente = buscarPorId(id);
        if (ingrediente != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(ingrediente);
            entityManager.getTransaction().commit();
        }
    }
}
