/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.testes;

import br.com.gartech.nfse.integrador.jpa.EntityManagerUtil;
import br.com.gartech.nfse.integrador.model.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gilson
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();

        Pais p1 = new Pais();
        //p1.setPaisID(6);
        p1.setNome("BRASIL");
        p1.setIso("BRA");

        
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        em.close();

        
    }
    
}
