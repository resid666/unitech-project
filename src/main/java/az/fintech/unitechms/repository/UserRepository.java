package com.fintech.unitech.repository;

import com.fintech.unitech.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPin(String pin);

    Optional<User> findByPinAndPassword(String pin, String password);

}
