package com.example.mynotes.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mynotes.mynotes.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
	
	Notes findByTitle(final String title);

}
