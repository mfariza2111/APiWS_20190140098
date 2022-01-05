/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekakhirkelasc.projek.akhir.kelas.c;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import projekakhirkelasc.projek.akhir.kelas.c.exceptions.NonexistentEntityException;
import projekakhirkelasc.projek.akhir.kelas.c.exceptions.PreexistingEntityException;

/**
 *
 * @author ASUS
 */
public class NamapasienJpaController implements Serializable {

    public NamapasienJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projekakhirkelasc_projek.akhir.kelas.c_jar_0.0.1-SNAPSHOTPU");;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public NamapasienJpaController() {
    }

    public void create(Namapasien namapasien) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(namapasien);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNamapasien(namapasien.getId()) != null) {
                throw new PreexistingEntityException("Namapasien " + namapasien + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Namapasien namapasien) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            namapasien = em.merge(namapasien);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = namapasien.getId();
                if (findNamapasien(id) == null) {
                    throw new NonexistentEntityException("The namapasien with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Namapasien namapasien;
            try {
                namapasien = em.getReference(Namapasien.class, id);
                namapasien.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The namapasien with id " + id + " no longer exists.", enfe);
            }
            em.remove(namapasien);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Namapasien> findNamapasienEntities() {
        return findNamapasienEntities(true, -1, -1);
    }

    public List<Namapasien> findNamapasienEntities(int maxResults, int firstResult) {
        return findNamapasienEntities(false, maxResults, firstResult);
    }

    private List<Namapasien> findNamapasienEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Namapasien.class));
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

    public Namapasien findNamapasien(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Namapasien.class, id);
        } finally {
            em.close();
        }
    }

    public int getNamapasienCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Namapasien> rt = cq.from(Namapasien.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
