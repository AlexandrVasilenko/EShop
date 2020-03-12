package ru.alx.javaproject.eshop.DTO;

import ru.alx.javaproject.eshop.entity.Ability;

import java.util.ArrayList;
import java.util.List;

public class AbilityResultDto {

    private List<Ability> abilityList = new ArrayList<>();

    public void addAbility(Ability ability) {
        this.abilityList.add(ability);
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }
}
