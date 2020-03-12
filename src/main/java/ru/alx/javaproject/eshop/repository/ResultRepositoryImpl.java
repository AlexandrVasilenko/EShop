package ru.alx.javaproject.eshop.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.Dao.BaseDao;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@org.springframework.stereotype.Repository
@Transactional
public class ResultRepositoryImpl extends BaseDao<Result> implements Repository<Result>,ResultRepository {

    @Override
    public void save(Result result) {
        //TODO implement auto DB table creation
    }

    @Override
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

    @Override
    public synchronized AbilityResultDto findResultList(int id) {
        AbilityResultDto list = new AbilityResultDto();
        list.setAbilityList(unwrapFromDB(findOneById(id)));
        return list;
    }

    @Override
    public synchronized void save(int playerId, List<Ability> abilityList) {
            super.deleteById(playerId);
            em.persist(wrapToDB(abilityList, playerId));
    }

    private Result wrapToDB(List<Ability> abilityList, int playerId) {
        Result result = new Result(playerId, "");

        for (Ability ability : abilityList) {
            if (ability.isObtained()) {
                result.setAbilityListString(result.getAbilityListString().concat(ability.getId().toString() + ","));
            }
        }
        return result;
    }

    private List<Ability> unwrapFromDB(Result result) {
        List<Ability> abilityList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(result.getAbilityListString(), ",");
        while (st.hasMoreTokens()) {
            abilityList.add(em.find(Ability.class, Long.parseLong(st.nextToken())));
        }
        return abilityList;
    }



}
