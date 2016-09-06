/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.testes.junit;

import br.com.gartech.nfse.integrador.jpa.EntityManagerUtil;
import br.com.gartech.nfse.integrador.model.Estado;
import br.com.gartech.nfse.integrador.model.Pais;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gilson
 */
public class PersistirEstadoTest {

    EntityManager em;
    
    public PersistirEstadoTest() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Estado e = new Estado();
            e.setNome("Rio Grande do Sul");
            e.setUf("RS");
            e.setPais(em.find(Pais.class, 2));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch(Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
