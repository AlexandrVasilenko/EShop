package ru.alx.javaproject.eshop.model;

import org.springframework.stereotype.Component;

@Component
public class Profile {

    private String playerName;
    private String nutritionType;
    private String sportActivityType;

    private int playerAge;
    private int sleepingHours;

    private boolean smoking;
    private boolean alcohol;
    private boolean inLove;

    public Profile(String playerName, int playerAge, boolean smoking) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.smoking = smoking;
    }

    public Profile(String playerName, String nutritionType, String sportActivityType, int playerAge, int sleepingHours, boolean smoking, boolean alcohol, boolean inLove) {
        this.playerName = playerName;
        this.nutritionType = nutritionType;
        this.sportActivityType = sportActivityType;
        this.playerAge = playerAge;
        this.sleepingHours = sleepingHours;
        this.smoking = smoking;
        this.alcohol = alcohol;
        this.inLove = inLove;
    }

    public Profile () {

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

    public String getSportActivityType() {
        return sportActivityType;
    }

    public void setSportActivityType(String sportActivityType) {
        this.sportActivityType = sportActivityType;
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

    @Override
    public String toString() {

        return  "Profile{" +
                "playerName='" + playerName + '\'' +
                ", nutritionType='" + nutritionType + '\'' +
                ", sportActivityType='" + sportActivityType + '\'' +
                ", playerAge=" + playerAge +
                ", sleepingHours=" + sleepingHours +
                ", smoking=" + smoking +
                ", alcohol=" + alcohol +
                ", inLove=" + inLove +
                '}';
    }
}
