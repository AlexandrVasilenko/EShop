package ru.alx.javaproject.eshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alx.javaproject.eshop.entity.Ability;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AbilitiesRepository {

    @PersistenceContext
    private EntityManager em;


    public synchronized List<Ability> findAll() {
        List<Ability> listOfAbilities = em.createQuery("from Ability", Ability.class).getResultList();
        return listOfAbilities;
    }

}
