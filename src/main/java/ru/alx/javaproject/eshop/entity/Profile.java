package ru.alx.javaproject.eshop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profiles")
public class Profile {

    private String playerName;
    private String nutritionType;
    private String gender;

    @Id
    @Column(name="playerid")
    private int playerId;
    private int playerAge;
    private int sleepingHours;
    private int sportActivity;

    private boolean smoking;
    private boolean alcohol;
    private boolean inLove;



    public Profile(String playerName, String nutritionType, int sportActivity, int playerAge, int sleepingHours, Boolean smoking, Boolean alcohol, Boolean inLove, String gender) {
        this.playerName = playerName;
        this.nutritionType = nutritionType;
        this.playerId = Math.abs(playerName.hashCode() + nutritionType.hashCode() + playerAge + sleepingHours);
        this.sportActivity = sportActivity;
        this.playerAge = playerAge;
        this.sleepingHours = sleepingHours;
        this.gender = gender;
        this.alcohol = alcohol != null && alcohol;
        this.smoking = smoking != null && smoking;
        this.inLove = inLove != null && inLove;

    }

    private Profile () {

    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNutritionType() {
        return nutritionType;
    }

    public void setNutritionType(String nutritionType) {
        this.nutritionType = nutritionType;
    }

    public int getSportActivity() {
        return sportActivity;
    }

    public void setSportActivity(int sportActivity) {
        this.sportActivity = sportActivity;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public int getSleepingHours() {
        return sleepingHours;
    }

    public void setSleepingHours(int sleepingHours) {
        this.sleepingHours = sleepingHours;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isInLove() {
        return inLove;
    }

    public void setInLove(boolean inLove) {
        this.inLove = inLove;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "playerName='" + playerName + '\'' +
                ", nutritionType='" + nutritionType + '\'' +
                ", playerAge=" + playerAge +
                ", sleepingHours=" + sleepingHours +
                ", sportActivity=" + sportActivity +
                ", smoking=" + smoking +
                ", alcohol=" + alcohol +
                ", inLove=" + inLove +
                ", gender=" + gender +
                '}';
    }
}
