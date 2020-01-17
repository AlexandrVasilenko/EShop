package ru.alx.javaproject.eshop.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alx.javaproject.eshop.DAO.ProfileDAO;
import ru.alx.javaproject.eshop.config.HibernateUtil;
import ru.alx.javaproject.eshop.entity.Profile;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository implements ProfileDAO {


    private List<Profile> profileList = new ArrayList<>();


    public synchronized List<Profile> findAll () {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Profile> profileList =  session.createQuery("from Profile", Profile.class).getResultList();
        session.getTransaction().commit();
        return profileList;

        /*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  session.createQuery("from profiles", Profile.class).list();
        }*/


        /*List<Profile> profiles = new ArrayList<>(profileList.size());
        for (Profile oneProfile: profileList) {
            profiles.add(oneProfile);
        }
        return profiles;*/
    }

    @Override
    public synchronized Profile findOne(int id) {

        Profile profile = new Profile ();
        //profile = (Profile)sessionFactory.getCurrentSession().createQuery("select * from profiles where playerid = 535");

        return profile;

        /*int index = getIndex(id);
        if (index == -1){
            return null;
        }
        return profileList.get(index);*/
    }

    @Override
    public synchronized Profile save (Profile profile)    {
        int index = getIndex(profile.getPlayerId());

        if (index == -1){
            return add(profile);
        }
        return update(profile,index);
    }

    @Override
    public synchronized void delete (int id) {
        int index = getIndex(id);
        if (index == -1) {
            return;
        }
        profileList.remove(index);
    }

    public synchronized void deleteAll(){
        for (Profile profile: findAll()) {
            delete(profile.getPlayerId());
        }
    }




    private int getIndex(int id) {
        for (int i = 0; i < profileList.size(); i++){
            Profile profile = profileList.get(i);
            if (profile.getPlayerId() == id){
                return i;
            }
        }
        return -1;
    }

    private Profile update(Profile profile, int index){
        Profile newProfile = clone(profile);
        profileList.set(index,newProfile);
        return clone(newProfile);
    }

    private Profile add (Profile profile){
        Profile newProfile = clone(profile);
        profileList.add(newProfile);
        return clone(newProfile);
    }

    private Profile clone (Profile profile){
        return new Profile (profile.getPlayerName(),profile.getNutritionType(),profile.getSportActivity(),profile.getPlayerAge(),profile.getSleepingHours(),profile.isSmoking(),profile.isAlcohol(),profile.isInLove(),
                profile.getGender());
    }
}
