package com.dhia.Films.service;

import com.dhia.Films.model.Role;
import com.dhia.Films.model.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);

}