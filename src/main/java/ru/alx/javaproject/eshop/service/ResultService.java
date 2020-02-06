package ru.alx.javaproject.eshop.service;

import ru.alx.javaproject.eshop.Dao.BaseDao;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.entity.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ResultService extends BaseDao<Result> {

    protected Result wrapToDB(List<Ability> abilityList, int playerId) {
        Result result = new Result(playerId, "");

        for (Ability ability : abilityList) {
            if (ability.isObtained()) {
                result.setAbilityListString(result.getAbilityListString().concat(ability.getId().toString() + ","));
            }
        }
        return result;
    }

    protected List<Ability> unwrapFromDB(Result result) {
        List<Ability> abilityList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(result.getAbilityListString(), ",");
        while (st.hasMoreTokens()) {
            abilityList.add(em.find(Ability.class, Long.parseLong(st.nextToken())));
        }
        return abilityList;
    }

}
