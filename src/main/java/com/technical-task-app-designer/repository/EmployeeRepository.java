package com.technical-task-app-designer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.technical-task-app-designer.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
  
}