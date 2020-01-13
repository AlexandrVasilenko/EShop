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

    public synchronized Profile findById (int id) {
        int index = getIndex(id);
        if (index == -1){
            return null;
        }
        return profileList.get(index);
    }

    public synchronized Profile save (Profile profile ){ return profile;}


    public synchronized void deleteById (int id) {
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
}
