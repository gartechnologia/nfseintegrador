/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.internal.EntityManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gilson
 */
public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

    private Logger log = LoggerFactory.getLogger(GenericDAOImpl.class);

    @PersistenceContext(name = "NfsePU")
    private EntityManager entityManager;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
	this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
		.getActualTypeArguments()[0];
    }

    public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

    public Session getSession() {
	log.debug("Tentando obter a sessao");
	final Object delegate = getEntityManager().getDelegate();
	log.debug(delegate.getClass().getName());
	if (delegate instanceof EntityManagerImpl) {
	    EntityManagerImpl entityManagerImpl = (EntityManagerImpl) delegate;
	    return entityManagerImpl.getSession();
	} else {
	    return (Session) delegate;
	}
    }

    public Class<T> getEntityClass() {
	return entityClass;
    }

    public void persist(T entity) {
	getEntityManager().persist(entity);
    }

    public T merge(T entity) {
	return getEntityManager().merge(entity);
    }

    public void remove(T entity) {
	entity = getEntityManager().merge(entity);
	getEntityManager().remove(entity);
    }

    public T findById(PK pk) {
	return getEntityManager().find(getEntityClass(), pk);
    }

    public void removeById(PK pk) {
	T entity = this.findById(pk);
	if (entity != null) {
	    this.remove(entity);
	}
    }

    @SuppressWarnings("unchecked")
    public List<T> listAll() {
	Query query = getEntityManager().createQuery("FROM " + getEntityClass().getName());
	List<T> result = query.getResultList();
	return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T entity) {
	Session session = getSession();
	Criteria criteria = session.createCriteria(getEntityClass()).add(Example.create(entity));
	List<T> result = criteria.list();
	return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T entity, int firstResult, int maxResults) {
	Session session = getSession();
	log.debug("findByExample on " + getEntityClass());
	Criteria criteria = session.createCriteria(getEntityClass()).add(Example.create(entity));
	criteria.setFirstResult(firstResult);
	if (maxResults > 0) {
	    criteria.setMaxResults(maxResults);
            criteria.addOrder(Order.asc("dataRecebimento"));
	}
	log.debug("findByExample result " + criteria.list().size());
	return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults) {
	Session session = getSession();
        
        session.doWork(new Work() {
            @Override
            public void execute(Connection cnctn) throws SQLException {
                cnctn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            }
        });
        
	Criteria criteria = detachedCriteria.getExecutableCriteria(session);
	criteria.setFirstResult(firstResult);
	if (maxResults > 0) {
	    criteria.setMaxResults(maxResults);
	}
        
//        criteria.setLockMode(LockMode.READ);  //linha adicionada para não fazer LOCK nas consulta já que é apenas consulta.
	List<T> result = criteria.list();
	return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T loadByCriteria(DetachedCriteria detachedCriteria) {
	Session session = getSession();
        
	T entity = (T) detachedCriteria.getExecutableCriteria(session).setMaxResults(1)
		.uniqueResult();
	return entity;
    }

    /**
     *
     * @param detachedCriteria
     * @return
     */
    @Override
    public Integer countByCriteria(DetachedCriteria detachedCriteria) {
	Session session = getSession();
	Integer total = (Integer) detachedCriteria.getExecutableCriteria(session).uniqueResult();
	return total;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByJpaQuery(Query query) {
	List<T> list = query.getResultList();
	return list;
    }

    @Override
    public int updateByJpaQuery(Query query) {
	int total = query.executeUpdate();
	return total;
    }

    @Override
    public Integer totalByJpaQuery(Query query) {
	Integer total = (Integer) query.setMaxResults(1).getSingleResult();
	return total;
    }
    
}
