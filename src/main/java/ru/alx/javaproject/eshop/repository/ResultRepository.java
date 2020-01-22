package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.DTO.AbilityResultDTO;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.entity.Result;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Repository
@Transactional
public class ResultRepository {

   @PersistenceContext
   private EntityManager em;


    public synchronized List<Result> findAll () {

        List<Result> resultList = em.createQuery("from Result", Result.class).getResultList();
        return resultList;
    }

    public synchronized AbilityResultDTO findOne(int id) {
        Result result = em.find(Result.class, id);
        AbilityResultDTO list = new AbilityResultDTO();
        list.setAbilityList(unwrapFromDB(result).get(id));
        return list;
    }


    public synchronized void save (int playerId, List<Ability> abilityList)    {
        int index = getIndex(playerId);
        if (index == -1){
            add(wrapToDB(abilityList,playerId));
        }
        update(wrapToDB(abilityList,playerId));
    }

    public synchronized void delete (int id) {
        int index = getIndex(id);
        if (index == -1) {
            return;
        }
        Result result = em.find(Result.class,id);
        em.remove(result);
    }

    private int getIndex(int id) {
        List<Result> resultList = em.createQuery("from Result", Result.class).getResultList();
        for (int i = 0; i < resultList.size(); i++){
            Result result = resultList.get(i);
            if (result.getPlayerId() == id){
                return i;
            }
        }
        return -1;
    }

    private void update(Result result){
        Result newResult = clone(result);
        delete(result.getPlayerId());
        em.persist(newResult);
    }

    private Result add (Result result){
        Result newResult = clone(result);
        em.persist(newResult);
        return clone(newResult);
    }

    private Result clone (Result result){
        return new Result(result.getPlayerId(), result.getAbilityListString());
    }

    private Result wrapToDB (List<Ability> abilityList, int playerId){
        Result result = new Result(playerId,"");

        for (Ability ability: abilityList) {
            if (ability.isObtained()){
                result.setAbilityListString(result.getAbilityListString().concat(ability.getId().toString() + ","));
            }
        }
        //result.setAbilityListString(abilityList.stream().filter(c -> c.isObtained()).toString() + ",");
        return result;
    }

    private Map<Integer, List<Ability>> unwrapFromDB (Result result){
        Map<Integer, List<Ability>> outputMap = new HashMap<>();

        List<Ability> abilityList = new ArrayList<>();

        //profile = em.createQuery("select x from Profile x where x.playerId = " + result.getPlayerId(), Profile.class).getSingleResult();
        int playerId = em.find(Profile.class,result.getPlayerId()).getPlayerId();

        StringTokenizer st = new StringTokenizer(result.getAbilityListString(), ",");
        while (st.hasMoreTokens()){
            abilityList.add(em.find(Ability.class, Long.parseLong(st.nextToken())));
        }
        outputMap.put(playerId,abilityList);
        return outputMap;

    }
}
