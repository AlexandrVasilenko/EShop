package ru.alx.javaproject.eshop.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.DAO.ProfileDAO;
import ru.alx.javaproject.eshop.config.HibernateUtil;
import ru.alx.javaproject.eshop.entity.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProfileRepository {

   @PersistenceContext
   private EntityManager em;

    private List<Profile> profileList = new ArrayList<>();


    public synchronized List<Profile> findAll () {

        List<Profile> profileList = em.createQuery("from Profile", Profile.class).getResultList();
        return profileList;

/*
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Profile> profileList =  session.createQuery("from Profile", Profile.class).getResultList();
        session.getTransaction().commit();
        return profileList;
*/

        /*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  session.createQuery("from profiles", Profile.class).list();
        }*/


        /*List<Profile> profiles = new ArrayList<>(profileList.size());
        for (Profile oneProfile: profileList) {
            profiles.add(oneProfile);
        }
        return profiles;*/
    }


    public synchronized Profile findOne(int id) {
        Profile profile = em.createQuery("select x from Profile x where x.playerId = " + id, Profile.class).getSingleResult();
        return profile;
    }


    public synchronized Profile save (Profile profile)    {
        int index = getIndex(profile.getPlayerId());
        if (index == -1){
            return add(profile);
        }
        return update(profile,index);
    }

    public synchronized void delete (int id) {
        int index = getIndex(id);
        if (index == -1) {
            return;
        }
        //em.createQuery("delete from Profile x where x.playerId = " + id);
        Profile profile = em.createQuery("select x from Profile x where x.playerId = " + id, Profile.class).getSingleResult();
        em.remove(profile);

    }

    public synchronized void deleteAll(){
        for (Profile profile: findAll()) {
            delete(profile.getPlayerId());
        }
    }




    private int getIndex(int id) {
        List<Profile> profileList = em.createQuery("from Profile", Profile.class).getResultList();
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
        delete(profile.getPlayerId());
        em.persist(newProfile);
        /*List<Profile> profileList = em.createQuery("from Profile", Profile.class).getResultList();
        profileList.set(index,newProfile);*/
        return clone(newProfile);
    }

    private Profile add (Profile profile){
        Profile newProfile = clone(profile);
        //profileList.add(newProfile);
        em.persist(newProfile);
        return clone(newProfile);
    }

    private Profile clone (Profile profile){
        return new Profile (profile.getPlayerName(),profile.getNutritionType(),profile.getSportActivity(),profile.getPlayerAge(),profile.getSleepingHours(),profile.isSmoking(),profile.isAlcohol(),profile.isInLove(),
                profile.getGender());
    }
}
