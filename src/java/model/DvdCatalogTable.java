/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author amam
 */
public class DvdCatalogTable {
    
    public static List<Dvdcatalog> findAllCatalog() { 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCart_60050132PU");
        EntityManager em = emf.createEntityManager();
        List<Dvdcatalog> catalogList = null;
        try {
            catalogList = (List<Dvdcatalog>) em.createNamedQuery("Dvdcatalog.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return catalogList;
    }    
    
    public static Dvdcatalog findCatalogById(int id) { 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCart_60050132PU");
        EntityManager em = emf.createEntityManager();
        Dvdcatalog catalogList = null;
        try {
            catalogList = em.find(Dvdcatalog.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return catalogList;
    }
    
     public static int updateCatalog(Dvdcatalog catalog) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCart_60050132PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, catalog.getDvdid());
            if (target == null) {
                return 0;
            }
            target.setDvdname(catalog.getDvdname());
            target.setPrice(catalog.getPrice());
            target.setRate(catalog.getRate());
            target.setYears(catalog.getYears());            
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
        
    }
    
    public static int removeCatalog(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCart_60050132PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    
    public static int insertCatalog(Dvdcatalog catalog) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCart_60050132PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, catalog.getDvdid());
            if (target != null) {
                return 0;
            }
            em.persist(catalog);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
