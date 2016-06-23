package com.translator.dao;

public interface CrudRepository<T> {
    T create(T t);

    void delete(T id);

    T find(T id);

    T update(T t);
}
