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
        super.save(result,result.getPlayerId());
    }

    public synchronized List<Result> findAll() {
        return super.findAll();
    }

    @Override
    public Result findOneById(int id) {
        return super.findOne(id).get();
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    public synchronized AbilityResultDto findResultList(int id) {
        Result result = em.find(Result.class, id);
        AbilityResultDto list = new AbilityResultDto();
        list.setAbilityList(unwrapFromDB(result).get(id));
        return list;
    }


    public synchronized void save(int playerId, List<Ability> abilityList) {
        int index = getIndex(playerId);
        if (index == -1) {
            add(wrapToDB(abilityList, playerId));
        }
        update(wrapToDB(abilityList, playerId));
    }



}
