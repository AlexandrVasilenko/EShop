package ru.alx.javaproject.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alx.javaproject.eshop.entity.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
