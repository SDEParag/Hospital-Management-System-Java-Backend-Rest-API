package com.hospital_management_system.repository;

import com.hospital_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


    Optional<User> findByUsernameOrEmail(String username, String email);


    Optional<User> findByUsername(String username);


    Boolean existsByUsername(String username);           //is username present in database return true


    Boolean existsByEmail(String email);                          //is email present in database return true


}
