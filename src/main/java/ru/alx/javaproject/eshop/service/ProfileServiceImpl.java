package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Override
    public void save(Profile p){

        if(repository.findById(p.getPlayerId()).isPresent() && !repository.findById(p.getPlayerId()).get().getAbilities().isEmpty()){
            Profile profile = repository.findById(p.getPlayerId()).get();
            profile.setAbilities(p.getAbilities());
            repository.save(profile);
        }
        repository.save(p);
    }

    @Override
    public List<Profile> findAll() {
        return repository.findAll();
    }

    @Override
    public Profile findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
