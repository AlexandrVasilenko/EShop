package ru.alx.javaproject.eshop.Dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findOne (int id);

    List<T> findAll();

    void save(T t);

    void update(T t, int id);

    void delete(T t);

    void deleteById (int id);
}
