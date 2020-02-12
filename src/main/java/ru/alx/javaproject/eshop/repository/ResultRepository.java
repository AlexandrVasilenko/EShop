package ru.alx.javaproject.eshop.repository;

import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.entity.Ability;

import java.util.List;

public interface ResultRepository {

     AbilityResultDto findResultList(int id);

     void save(int playerId, List<Ability> abilityList);
}
