package ru.alx.javaproject.eshop.repository;

import java.util.List;

public interface RepositoryDao<T> {

    void save(T o);

    List<T> findAll();

    T findOneById(int id);

    void deleteById(int id);

    void deleteAll();

}
