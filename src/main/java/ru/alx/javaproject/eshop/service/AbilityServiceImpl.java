package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.repository.AbilityRepository;

import java.util.List;

@Service
public class AbilityServiceImpl implements AbilityService {

    @Autowired
    private AbilityRepository repository;

    @Override
    public List<Ability> findAll() {
        return repository.findAll();
    }
}
