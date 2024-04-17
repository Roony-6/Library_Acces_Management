/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_acces_management.PERSISTENCE;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import com.mycompany.library_acces_management.PERSISTENCE.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author roony
 */
public class MesaJpaController implements Serializable {

    public MesaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
        public MesaJpaController(){
      emf=Persistence.createEntityManagerFactory("biblioteca_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mesa mesa) {
        if (mesa.getListaAlumnos() == null) {
            mesa.setListaAlumnos(new ArrayList<Alumno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Alumno> attachedListaAlumnos = new ArrayList<Alumno>();
            for (Alumno listaAlumnosAlumnoToAttach : mesa.getListaAlumnos()) {
                listaAlumnosAlumnoToAttach = em.getReference(listaAlumnosAlumnoToAttach.getClass(), listaAlumnosAlumnoToAttach.getId());
                attachedListaAlumnos.add(listaAlumnosAlumnoToAttach);
            }
            mesa.setListaAlumnos(attachedListaAlumnos);
            em.persist(mesa);
            for (Alumno listaAlumnosAlumno : mesa.getListaAlumnos()) {
                Mesa oldMesaOfListaAlumnosAlumno = listaAlumnosAlumno.getMesa();
                listaAlumnosAlumno.setMesa(mesa);
                listaAlumnosAlumno = em.merge(listaAlumnosAlumno);
                if (oldMesaOfListaAlumnosAlumno != null) {
                    oldMesaOfListaAlumnosAlumno.getListaAlumnos().remove(listaAlumnosAlumno);
                    oldMesaOfListaAlumnosAlumno = em.merge(oldMesaOfListaAlumnosAlumno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mesa mesa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesa persistentMesa = em.find(Mesa.class, mesa.getId());
            List<Alumno> listaAlumnosOld = persistentMesa.getListaAlumnos();
            List<Alumno> listaAlumnosNew = mesa.getListaAlumnos();
            List<Alumno> attachedListaAlumnosNew = new ArrayList<Alumno>();
            for (Alumno listaAlumnosNewAlumnoToAttach : listaAlumnosNew) {
                listaAlumnosNewAlumnoToAttach = em.getReference(listaAlumnosNewAlumnoToAttach.getClass(), listaAlumnosNewAlumnoToAttach.getId());
                attachedListaAlumnosNew.add(listaAlumnosNewAlumnoToAttach);
            }
            listaAlumnosNew = attachedListaAlumnosNew;
            mesa.setListaAlumnos(listaAlumnosNew);
            mesa = em.merge(mesa);
            for (Alumno listaAlumnosOldAlumno : listaAlumnosOld) {
                if (!listaAlumnosNew.contains(listaAlumnosOldAlumno)) {
                    listaAlumnosOldAlumno.setMesa(null);
                    listaAlumnosOldAlumno = em.merge(listaAlumnosOldAlumno);
                }
            }
            for (Alumno listaAlumnosNewAlumno : listaAlumnosNew) {
                if (!listaAlumnosOld.contains(listaAlumnosNewAlumno)) {
                    Mesa oldMesaOfListaAlumnosNewAlumno = listaAlumnosNewAlumno.getMesa();
                    listaAlumnosNewAlumno.setMesa(mesa);
                    listaAlumnosNewAlumno = em.merge(listaAlumnosNewAlumno);
                    if (oldMesaOfListaAlumnosNewAlumno != null && !oldMesaOfListaAlumnosNewAlumno.equals(mesa)) {
                        oldMesaOfListaAlumnosNewAlumno.getListaAlumnos().remove(listaAlumnosNewAlumno);
                        oldMesaOfListaAlumnosNewAlumno = em.merge(oldMesaOfListaAlumnosNewAlumno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesa.getId();
                if (findMesa(id) == null) {
                    throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.");
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
            Mesa mesa;
            try {
                mesa = em.getReference(Mesa.class, id);
                mesa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.", enfe);
            }
            List<Alumno> listaAlumnos = mesa.getListaAlumnos();
            for (Alumno listaAlumnosAlumno : listaAlumnos) {
                listaAlumnosAlumno.setMesa(null);
                listaAlumnosAlumno = em.merge(listaAlumnosAlumno);
            }
            em.remove(mesa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mesa> findMesaEntities() {
        return findMesaEntities(true, -1, -1);
    }

    public List<Mesa> findMesaEntities(int maxResults, int firstResult) {
        return findMesaEntities(false, maxResults, firstResult);
    }

    private List<Mesa> findMesaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mesa.class));
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

    public Mesa findMesa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mesa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mesa> rt = cq.from(Mesa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
