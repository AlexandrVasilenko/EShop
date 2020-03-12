package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return repository.findById((long)id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById((long)id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login).orElse(null);
    }
}
