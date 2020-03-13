package ru.alx.javaproject.eshop.entity;


import ru.alx.javaproject.eshop.service.TimeReserveValidation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerId")
    private int playerId;

    @Column(name = "playerAge", columnDefinition = "integer default 1")
    private int playerAge;

    @Column(name = "sleepingHours", columnDefinition = "integer default 1")
    private int sleepingHours;

    @Column(name = "sportActivity", columnDefinition = "integer default 1")
    private int sportActivity;

    @Column(name = "timeReserve", columnDefinition = "integer default 1")
    private int timeReserve;

    @Column(name = "playerName", columnDefinition = "varchar(255) default 'John'")
    private String playerName;

    @Column(name = "nutritionType", columnDefinition = "varchar(255) default 'Vegan'")
    private String nutritionType;

    @Column(name = "gender", columnDefinition = "varchar(255) default 'Male'")
    private String gender;

    @Column(name = "smoking", columnDefinition = "boolean default false")
    private boolean smoking;

    @Column(name = "alcohol", columnDefinition = "boolean default false")
    private boolean alcohol;

    @Column(name = "inLove", columnDefinition = "boolean default false")
    private boolean inLove;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Ability> abilities;

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

        TimeReserveValidation trvs = new TimeReserveValidation();
        this.timeReserve = trvs.calculateTimeReserve(gender, nutritionType, playerAge, sleepingHours, sportActivity, this.smoking, this.alcohol, this.inLove);
    }

    private Profile() {    }

    public int getTimeReserve() {
        return timeReserve;
    }

    public void setTimeReserve(int timeReserve) {
        this.timeReserve = timeReserve;
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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "playerId=" + playerId +
                ", playerAge=" + playerAge +
                ", sleepingHours=" + sleepingHours +
                ", sportActivity=" + sportActivity +
                ", timeReserve=" + timeReserve +
                ", playerName='" + playerName + '\'' +
                ", nutritionType='" + nutritionType + '\'' +
                ", gender='" + gender + '\'' +
                ", smoking=" + smoking +
                ", alcohol=" + alcohol +
                ", inLove=" + inLove +
                ", abilities=" + abilities +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return playerId == profile.playerId &&
                playerAge == profile.playerAge &&
                playerName.equals(profile.playerName) &&
                gender.equals(profile.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerAge, playerName, gender);
    }
}
