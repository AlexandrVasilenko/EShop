package ru.alx.javaproject.eshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String picture;
    private String name;
    private String level;
    private String description;
    private int price;
    private boolean obtained;

    @ManyToOne()
    private Profile profile;

    public Ability(int id, String picture, String name, String level, String description, int price) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.level = level;
        this.description = description;
        this.price = price;
        this.obtained = false;

    }

    public Ability() {

    }

    public boolean isObtained() {
        return obtained;
    }

    public void setObtained(boolean obtained) {
        this.obtained = obtained;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability ability = (Ability) o;
        return price == ability.price &&
                Objects.equals(id, ability.id) &&
                Objects.equals(name, ability.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
