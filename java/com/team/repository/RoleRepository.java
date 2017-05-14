package com.team.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
