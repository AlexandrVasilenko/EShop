package ru.alx.javaproject.eshop.repository;

import ru.alx.javaproject.eshop.Dao.BaseDao;
import ru.alx.javaproject.eshop.entity.Profile;

import java.util.List;

@org.springframework.stereotype.Repository
public class ProfileRepositoryImpl extends BaseDao<Profile> implements Repository<Profile>,ProfileRepository {

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
