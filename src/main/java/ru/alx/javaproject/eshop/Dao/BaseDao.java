package ru.alx.javaproject.eshop.Dao;

import com.sun.istack.Nullable;
import ru.alx.javaproject.eshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class BaseDao<T> implements Dao {

    @PersistenceContext
    protected EntityManager em;

    public synchronized Optional<T> findOne(@Nullable Object id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(em.find(getEntityClassType(), id));
    }

    public synchronized List findAll() {
        return null;
    }


    public synchronized void update(Object o, int id) {

    }

    public synchronized void delete(Object o) {

    }

    public synchronized void deleteById(int id) {

    }

    protected Class<T> getEntityClassType() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
