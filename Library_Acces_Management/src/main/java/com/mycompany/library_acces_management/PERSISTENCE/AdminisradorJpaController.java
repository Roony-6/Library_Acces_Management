
package com.mycompany.library_acces_management.PERSISTENCE;

import com.mycompany.library_acces_management.LOGIC.Adminisrador;
import com.mycompany.library_acces_management.PERSISTENCE.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AdminisradorJpaController implements Serializable {

   
    public AdminisradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AdminisradorJpaController(){
      emf=Persistence.createEntityManagerFactory("biblioteca_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Adminisrador adminisrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(adminisrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Adminisrador adminisrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            adminisrador = em.merge(adminisrador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = adminisrador.getId();
                if (findAdminisrador(id) == null) {
                    throw new NonexistentEntityException("The adminisrador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Adminisrador adminisrador;
            try {
                adminisrador = em.getReference(Adminisrador.class, id);
                adminisrador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The adminisrador with id " + id + " no longer exists.", enfe);
            }
            em.remove(adminisrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Adminisrador> findAdminisradorEntities() {
        return findAdminisradorEntities(true, -1, -1);
    }

    public List<Adminisrador> findAdminisradorEntities(int maxResults, int firstResult) {
        return findAdminisradorEntities(false, maxResults, firstResult);
    }

    private List<Adminisrador> findAdminisradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Adminisrador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Adminisrador findAdminisrador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Adminisrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdminisradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Adminisrador> rt = cq.from(Adminisrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
