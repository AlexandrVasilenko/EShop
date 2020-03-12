package ru.alx.javaproject.eshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Result;
import ru.alx.javaproject.eshop.repository.Repository;
import ru.alx.javaproject.eshop.repository.ResultRepository;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private Repository<Result> repository;

    @Override
    public AbilityResultDto findResultList(int id) {
        return resultRepository.findResultList(id);
    }

    @Override
    public void save(int playerId, List<Ability> abilityList) {
        resultRepository.save(playerId,abilityList);
    }

    @Override
    public List<Result> findAll() {
        return repository.findAll();
    }

    @Override
    public Result findOneById(int id) {
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
