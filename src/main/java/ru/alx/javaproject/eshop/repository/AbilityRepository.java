package ru.alx.javaproject.eshop.repository;

import ru.alx.javaproject.eshop.entity.Ability;

import java.util.List;

public interface AbilityRepository {

    List<Ability> findAll();
}
