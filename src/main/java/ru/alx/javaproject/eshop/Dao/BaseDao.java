package ru.alx.javaproject.eshop.Dao;

import com.sun.istack.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseDao<T> {

    @PersistenceContext
    protected EntityManager em;

    Type t = getClass().getGenericSuperclass();

    protected synchronized Optional<T> findOne(@Nullable int id) {
        return Optional.ofNullable(em.find(getEntityClassType(), id));
    }

    protected synchronized List<T> findAll() {
        return em.createQuery("from "+ getEntityClassType().getName(), getEntityClassType()).getResultList();
    }

    protected synchronized void save(Object o, int id) {
        if (o.equals(findOne(id).isPresent())) {
            update(o, id);
        } else {
            add(o);
        }
    }

    protected synchronized void delete(Object o) {
        em.remove(o);
    }

    protected synchronized void deleteById(int id) {
        Optional<T> requiredObjectToDelete = findOne(id);

        //requiredObjectToDelete.ifPresent(value -> em.remove(value));
        if (requiredObjectToDelete.isPresent()){
            em.remove(requiredObjectToDelete.get());
        }
    }

    private void update (Object o, int id) {
        deleteById(id);
        add(o);
    }

    private void add (Object o) {
        em.persist(o);
    }

    protected Class<T> getEntityClassType() {
        return (Class<T>) ((ParameterizedType)((Class)t).getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
