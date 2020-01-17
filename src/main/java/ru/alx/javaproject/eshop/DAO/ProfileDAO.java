package ru.alx.javaproject.eshop.DAO;


import ru.alx.javaproject.eshop.entity.Profile;

public interface ProfileDAO {

    public void delete (int id);
    public Profile save (Profile profile);
    public Profile findOne (int id);



}
