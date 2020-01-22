package ru.alx.javaproject.eshop.DAO;


import ru.alx.javaproject.eshop.entity.Profile;

public interface ProfileDAO {

    void delete(int id);

    Profile save(Profile profile);

    Profile findOne(int id);


}
