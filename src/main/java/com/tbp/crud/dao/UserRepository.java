package com.tbp.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbp.crud.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
