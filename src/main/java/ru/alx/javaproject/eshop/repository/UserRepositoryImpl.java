package ru.alx.javaproject.eshop.repository;

import ru.alx.javaproject.eshop.Dao.BaseDao;
import ru.alx.javaproject.eshop.entity.User;

import java.util.List;

@org.springframework.stereotype.Repository
public class UserRepositoryImpl extends BaseDao<User> implements Repository<User>,UserRepository {


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
