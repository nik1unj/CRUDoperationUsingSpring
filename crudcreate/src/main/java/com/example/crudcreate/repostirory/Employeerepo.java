package com.example.crudcreate.repostirory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.crudcreate.model.Employee;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Integer> {

	
	
}
