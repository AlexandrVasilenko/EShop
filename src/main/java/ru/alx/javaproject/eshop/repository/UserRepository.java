package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.Dao.Dao;
import ru.alx.javaproject.eshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepository implements Dao<User> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> findOne(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public synchronized void save(User user) {
        int index = getIndex(user.getId());
        if (index == -1) {
            add(user);
        }
    }

    @Override
    public void update(User user, int id) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    private User add(User user) {
        User newUser = clone(user);
        newUser.setPassword(newUser.getPassword());
        //profileList.add(newProfile);
        em.persist(newUser);
        return clone(newUser);
    }

    private User clone(User user) {
        return new User(user.getLogin(), user.getPassword());
    }

    private int getIndex(int id) {
        List<User> userList = em.createQuery("from User", User.class).getResultList();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
