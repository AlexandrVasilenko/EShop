package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.Dao.BaseDao;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.Repository;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private Repository<Profile> repository;


    @Override
    public void save(Profile p) {
        repository.save(p);
    }

    @Override
    public List<Profile> findAll() {
        return repository.findAll();
    }

    @Override
    public Profile findOneById(int id) {
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
