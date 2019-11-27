package com.example.crudcreate.model;

import javax.persistence.*;

@Entity
@Table(name="employee")

public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int id;
	public String name;
	public String role;
    public Employee() {}  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Employee(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	

	
}
