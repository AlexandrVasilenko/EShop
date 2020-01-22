package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.entity.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProfileRepository {

    @PersistenceContext
    private EntityManager em;

    public synchronized List<Profile> findAll() {

        List<Profile> profileList = em.createQuery("from Profile", Profile.class).getResultList();
        return profileList;
    }


    public synchronized Profile findOne(int id) {
        Profile profile = em.createQuery("select x from Profile x where x.playerId = " + id, Profile.class).getSingleResult();
        return profile;
    }


    public synchronized Profile save(Profile profile) {
        int index = getIndex(profile.getPlayerId());
        if (index == -1) {
            return add(profile);
        }
        return update(profile, index);
    }

    public synchronized void delete(int id) {
        int index = getIndex(id);
        if (index == -1) {
            return;
        }
        Profile profile = em.createQuery("select x from Profile x where x.playerId = " + id, Profile.class).getSingleResult();
        em.remove(profile);
    }

    public synchronized void deleteAll() {
        for (Profile profile : findAll()) {
            delete(profile.getPlayerId());
        }
    }


    private int getIndex(int id) {
        List<Profile> profileList = em.createQuery("from Profile", Profile.class).getResultList();
        for (int i = 0; i < profileList.size(); i++) {
            Profile profile = profileList.get(i);
            if (profile.getPlayerId() == id) {
                return i;
            }
        }
        return -1;
    }

    private Profile update(Profile profile, int index) {
        Profile newProfile = clone(profile);
        delete(profile.getPlayerId());
        em.persist(newProfile);
        return clone(newProfile);
    }

    private Profile add(Profile profile) {
        Profile newProfile = clone(profile);
        //profileList.add(newProfile);
        em.persist(newProfile);
        return clone(newProfile);
    }

    private Profile clone(Profile profile) {
        return new Profile(profile.getPlayerName(), profile.getNutritionType(), profile.getSportActivity(), profile.getPlayerAge(), profile.getSleepingHours(), profile.isSmoking(), profile.isAlcohol(), profile.isInLove(),
                profile.getGender());
    }
}
