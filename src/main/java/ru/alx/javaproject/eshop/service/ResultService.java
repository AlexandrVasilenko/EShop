package ru.alx.javaproject.eshop.service;

import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Result;

import java.util.List;

public interface ResultService {

    AbilityResultDto findResultList(int id);

    void save(int playerId, List<Ability> abilityList);

    List<Result> findAll();

    Result findOneById(int id);

    void deleteById(int id);

    void deleteAll();
}
