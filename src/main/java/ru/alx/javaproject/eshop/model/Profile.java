package ru.alx.javaproject.eshop.model;

import org.springframework.stereotype.Component;

@Component
public class Profile {

    private String playerName;
    private String nutritionType;

    private int playerAge;
    private int sleepingHours;
    private int sportActivity;

    private boolean smoking;
    private boolean alcohol;
    private boolean inLove;
    private boolean genderMale;

    public Profile(String playerName, int playerAge, boolean smoking, boolean genderMale) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.smoking = smoking;
        this.genderMale = genderMale;

    }

    public Profile(String playerName, String nutritionType, int sportActivity, int playerAge, int sleepingHours, boolean smoking, boolean alcohol, boolean inLove, boolean genderMale) {
        this.playerName = playerName;
        this.nutritionType = nutritionType;
        this.sportActivity = sportActivity;
        this.playerAge = playerAge;
        this.sleepingHours = sleepingHours;
        this.smoking = smoking;
        this.alcohol = alcohol;
        this.inLove = inLove;
        this.genderMale = genderMale;
    }

    private Profile () {

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

    public boolean isGenderMale() {
        return genderMale;
    }

    public void setGenderMale(boolean genderMale) {
        this.genderMale = genderMale;
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
                ", genderMale=" + genderMale +
                '}';
    }
}
