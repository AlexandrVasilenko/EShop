package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.repository.Repository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Repository<User> repository;


    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOneById(int id) {
        return repository.findOneById(id);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
