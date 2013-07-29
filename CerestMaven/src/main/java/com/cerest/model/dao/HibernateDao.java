package com.cerest.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author moraes
 */
public class HibernateDao<T> implements InterfaceDao<T>, Serializable{

    private static final long serialVersionUID=1L;
    private Class<T> classe;
    private Session session;

    public HibernateDao(Class<T> classe,Session session) {
        super();
        this.classe = classe;
        this.session=session;
    }
    @Override
    public void save(T entity) {
        session.save(entity);                
    }

    @Override
    public void update(T entiry) {
        session.update(entiry);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity=(T)session.get(classe,id);
        return entity;        
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity;
        entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntity() {
        List<T> entities=(List<T>) session.createCriteria(classe).list();
        return entities;
    }

    @Override
    public List<T> getListEntityByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }
    
}
