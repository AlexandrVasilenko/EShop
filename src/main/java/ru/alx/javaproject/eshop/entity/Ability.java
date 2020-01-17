package ru.alx.javaproject.eshop.entity;

import java.util.Objects;

public class Ability {

    private Long id;
    private String picture;
    private String name;
    private String description;
    private int price;

    public Ability (Long id, String picture, String name, String description, int price){
    this.id = id;
    this.picture = picture;
    this.name = name;
    this.description = description;
    this.price = price;

    }

    private Ability (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
