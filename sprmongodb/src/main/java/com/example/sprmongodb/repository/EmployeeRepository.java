package com.example.sprmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sprmongodb.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
