package ru.alx.javaproject.eshop.repository;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Repository;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.ProfileService;

import java.util.List;

@Repository
public class ProfileRepository extends ProfileService implements RepositoryDao<Profile> {

    @Override
    public void save(Profile profile) {
        super.save(profile,profile.getPlayerId());
    }

    @Override
    public List<Profile> findAll() {
        return super.findAll();
    }


    @Override
    public Profile findOneById(int id) {
        return super.findOne(id).get();
    }


    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll(){
        for (Profile profile : findAll()) {
            deleteById(profile.getPlayerId());
        }
    }
}
