package ru.alx.javaproject.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alx.javaproject.eshop.entity.Ability;

import java.util.List;

public interface AbilityRepository extends JpaRepository<Ability, Long> {

}
