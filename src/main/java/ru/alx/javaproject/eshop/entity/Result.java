package ru.alx.javaproject.eshop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result {

    @Id
    private int playerId;

    @Column(name = "abilitylist")
    private String abilityListString;

    public Result(int playerId, String abilityListString) {
        this.playerId = playerId;
        this.abilityListString = abilityListString;
    }

    public Result() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getAbilityListString() {
        return abilityListString;
    }

    public void setAbilityListString(String abilityListString) {
        this.abilityListString = abilityListString;
    }
}
