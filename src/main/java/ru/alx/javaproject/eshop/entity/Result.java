package ru.alx.javaproject.eshop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name="results")
public class Result {

    @Id
    int playerId;

    @Column (name="abilitylist")
    String abilityListString;



}
