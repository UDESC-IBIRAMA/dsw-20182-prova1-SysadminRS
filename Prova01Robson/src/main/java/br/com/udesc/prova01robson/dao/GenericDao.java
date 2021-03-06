package br.com.udesc.prova01robson.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author SYSADMIN
 */

public class GenericDao {
    
    private EntityManager em = null;

    public GenericDao() {
        EntityManagerFactory emf
                = javax.persistence.Persistence.createEntityManagerFactory("ProvaPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void salvar(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Object ler(Class classe, long id) {
        Object object = null;
        em.getTransaction().begin();
        try {
            object = em.find(classe, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return object;
    }
    
    
    public void atualizar(Object object) {
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
