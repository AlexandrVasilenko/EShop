package ru.alx.javaproject.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alx.javaproject.eshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByLogin(String login);

}
