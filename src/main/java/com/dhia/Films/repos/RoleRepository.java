package com.dhia.Films.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhia.Films.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}