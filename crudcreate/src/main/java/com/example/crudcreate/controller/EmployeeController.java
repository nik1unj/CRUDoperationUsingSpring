package com.example.crudcreate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudcreate.model.Employee;
import com.example.crudcreate.repostirory.Employeerepo;
import com.example.crudcreate.service.EmployeeService;


@RestController
public class EmployeeController {

@Autowired
public Employeerepo emprepo;
	@Autowired
	public EmployeeService empserv;
	@GetMapping("/all")
	public List<Employee> getemp()
	{
		return empserv.getEmployee();
	}

	@PostMapping("/add")
	public Employee addemp(@RequestBody Employee emp)
	{
		return empserv.addemp(emp);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Void> getempbyid(@PathVariable int id)
	{
		Optional<Employee> e = emprepo.findById(id);
		if(!e.isEmpty())
			return new ResponseEntity(e,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Void> getempbyname(@PathVariable String name)
	{
		  Employee e=empserv.getempbyname(name);
		 if(!e.equals(null))
		    return new ResponseEntity(e,HttpStatus.OK);
			 return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		 
	   	}
	@GetMapping("/role/{role}")
	public List<Employee> getempbyrole(@PathVariable String role)
	{
		List<Employee> elist = new ArrayList<>();
		  List<Employee> list = emprepo.findAll(); for(Employee e:list) {
		  if(e.getRole().equals(role)) { 
		     elist.add(e);
		  }
		  }
		  return elist;
		 
	   	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deletemp(@PathVariable int id)
	{
		Optional<Employee> e = emprepo.findById(id);
		if(e.isEmpty())
			return new ResponseEntity(e,HttpStatus.NO_CONTENT);
		emprepo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
	{
		List<Employee> list= emprepo.findAll();
	  for(Employee e:list)
	  {
		  if(e.getId()==id)
		  {
			  e.setName(emp.getName());
			  e.setRole(emp.getRole());
			 emprepo.save(e);
		  }
	  }
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	
	
	
}
