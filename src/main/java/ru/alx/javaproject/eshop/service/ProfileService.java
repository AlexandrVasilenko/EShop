package ru.alx.javaproject.eshop.service;

import ru.alx.javaproject.eshop.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    void save(Profile p);

    List<Profile> findAll();

    Profile findById(int id);

    void deleteById(int id);

    void deleteAll();
}
