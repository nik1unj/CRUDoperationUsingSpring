package com.example.crudcreate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crudcreate.model.Employee;
import com.example.crudcreate.repostirory.Employeerepo;

@Service
public class EmployeeService {
	
	@Autowired
public Employeerepo emprepo;

	public List<Employee> getEmployee()
	{
		return emprepo.findAll();
	  
	}
	
	public Employee addemp(Employee emp)
	{
		return emprepo.save(emp);
	}
	public Employee getempbyname(String name)
	{
		 List<Employee> list = emprepo.findAll(); for(Employee e:list) {
			  if(e.getName().equals(name)) {return e; } 
		 }
		 return null;
	}
	
}
