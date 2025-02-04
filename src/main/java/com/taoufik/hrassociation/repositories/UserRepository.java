package com.taoufik.hrassociation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taoufik.hrassociation.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    
}
