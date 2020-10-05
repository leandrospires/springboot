package com.example.mynotes.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mynotes.mynotes.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail (final String email);

}
