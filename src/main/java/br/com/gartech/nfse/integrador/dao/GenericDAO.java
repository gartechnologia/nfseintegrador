/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Gilson
 */
public interface GenericDAO <T, PK extends Serializable> {

    public void setEntityManager(EntityManager entityManager);
    public EntityManager getEntityManager();
    public Session getSession();
    public Class<T> getEntityClass();
    public void persist(T entity);
    public T merge(T entity);
    public void remove(T entity);
    public T findById(PK id);
    public void removeById(PK id);
    public List<T> listAll();
    public List<T> findByExample(T entity);
    public List<T> findByExample(T entity, int firstResult, int maxResults);
    public List<T> findByCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults);
    public T loadByCriteria(DetachedCriteria detachedCriteria);
    public Integer countByCriteria(DetachedCriteria detachedCriteria);
    public List<T> findByJpaQuery(Query query);
    public int updateByJpaQuery(Query query);
    public Integer totalByJpaQuery(Query query);    
}
