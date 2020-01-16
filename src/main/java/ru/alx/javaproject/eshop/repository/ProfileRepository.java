package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import ru.alx.javaproject.eshop.model.Profile;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository {

    private List<Profile> profileList = new ArrayList<>();

    public synchronized List<Profile> findAll () {
        List<Profile> profiles = new ArrayList<>(profileList.size());
        for (Profile oneProfile: profileList) {
            profiles.add(oneProfile);
        }
        return profiles;
    }

    public synchronized Profile findOne(int id) {
        int index = getIndex(id);
        if (index == -1){
            return null;
        }
        return profileList.get(index);
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
        profileList.remove(index);
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
        return new Profile (profile.getPlayerName(),profile.getNutritionType(),profile.getPlayerId(),profile.getSportActivity(),profile.getPlayerAge(),profile.getSleepingHours(),profile.isSmoking(),profile.isAlcohol(),profile.isInLove(),profile.isGenderMale());
    }
}
