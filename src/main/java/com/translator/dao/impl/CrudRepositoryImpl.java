package com.translator.dao.impl;

import com.translator.dao.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class CrudRepositoryImpl<T> implements CrudRepository<T> {
    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public CrudRepositoryImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public void delete(final T id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T find(final T id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);
    }
}
