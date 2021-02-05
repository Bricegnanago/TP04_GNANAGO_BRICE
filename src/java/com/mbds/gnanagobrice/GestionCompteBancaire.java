/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds.gnanagobrice;

import com.mbds.gnanago.CompteBancaire;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gnana
 */

@Stateless
public class GestionCompteBancaire {
     @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public CompteBancaire creerCompteBancaire(String lastName, String firstName, String acountNumber, double balance) {
        CompteBancaire c = new CompteBancaire(lastName, firstName,  acountNumber, balance);
        em.persist(c);
        return c;
    }

    /**
     *
     * @return
     */
    public Collection<CompteBancaire> getAllCompteBancaires() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select c from CompteBancaire c");
        return q.getResultList();
    }
}
