package ru.alx.javaproject.eshop.service;

import ru.alx.javaproject.eshop.entity.Profile;

import java.util.List;

public interface ProfileService {

    void save(Profile p);

    List<Profile> findAll();

    Profile findOneById(int id);

    void deleteById(int id);

    void deleteAll();

}
