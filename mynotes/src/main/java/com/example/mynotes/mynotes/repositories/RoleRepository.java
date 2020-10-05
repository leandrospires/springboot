package com.example.mynotes.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mynotes.mynotes.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(final String role);
	
}
