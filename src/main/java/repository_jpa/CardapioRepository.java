package repository_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Cardapio;

import java.util.List;

public class CardapioRepository {

    private final EntityManager entityManager;

    public CardapioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cardapio salvar(Cardapio cardapio) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cardapio);
            transaction.commit();
            return cardapio;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Cardapio atualizar(Cardapio cardapio) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Cardapio atualizado = entityManager.merge(cardapio);
            transaction.commit();
            return atualizado;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void deletar(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Cardapio cardapio = entityManager.find(Cardapio.class, id);
            if (cardapio != null) {
                entityManager.remove(cardapio);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Cardapio buscarPorId(int id) {
        return entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> buscarTodos() {
        return entityManager.createQuery("FROM Cardapio", Cardapio.class).getResultList();
    }
}