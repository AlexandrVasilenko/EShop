package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.service.UserService;

import java.util.List;

@Repository
public class UserRepository extends UserService implements RepositoryDao<User> {


    @Override
    public void save(User user) {
        super.save(user,user.getId());
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Override
    public User findOneById(int id) {
        return super.findOne(id).get();
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {
        for (User user : findAll()) {
            deleteById(user.getId());
        }
    }
}
