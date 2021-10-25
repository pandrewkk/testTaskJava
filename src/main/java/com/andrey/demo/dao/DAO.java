package com.andrey.demo.dao;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();

    T getById(long id);

    void add(T book);

    void delete(long id);
}
