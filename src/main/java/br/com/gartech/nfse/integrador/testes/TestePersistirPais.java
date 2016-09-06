/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.testes;

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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integradorPU");
        EntityManager em = emf.createEntityManager();

//        Pais p1 = new Pais();
//        p1.setNome("BRASIL");
//        p1.setIso("BRA");

        Pais p2 = new Pais();
        p2.setNome("GAR");
        p2.setIso("BRA");

        em.getTransaction().begin();
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
