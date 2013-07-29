/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cerest.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author moraes
 */
public interface InterfaceDao<T> {
    void save(T entity);
    void update(T entiry);
    void remove(T entity);
    void merge(T entity);
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    List<T> getEntity();
    List<T> getListEntityByDetachedCriteria(DetachedCriteria criteria);
    
    
    
}
