package com.dhia.Films.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhia.Films.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}