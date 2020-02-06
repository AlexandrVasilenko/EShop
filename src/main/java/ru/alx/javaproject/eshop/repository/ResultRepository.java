package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.entity.Result;
import ru.alx.javaproject.eshop.service.ResultService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Repository
public class ResultRepository extends ResultService implements RepositoryDao<Result> {

    @Override
    public void save(Result result) {
        //TODO implement auto DB table creation
    }

    public synchronized List<Result> findAll() {
        return super.findAll();
    }

    @Override
    public Result findOneById(int id) {
        return super.findOne(id).orElse(new Result());
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

    public synchronized AbilityResultDto findResultList(int id) {
        AbilityResultDto list = new AbilityResultDto();
        list.setAbilityList(unwrapFromDB(findOneById(id)));
        return list;
    }


    public synchronized void save(int playerId, List<Ability> abilityList) {
            super.deleteById(playerId);
            em.persist(wrapToDB(abilityList, playerId));
    }



}
