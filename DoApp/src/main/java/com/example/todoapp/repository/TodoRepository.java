package com.example.todoapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.domain.Todo;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>{

}
