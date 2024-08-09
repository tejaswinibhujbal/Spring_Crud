package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/emp")
	public List<Employee> getAllEmp(){
		return this.empservice.getAllEmployees();
	}
	
	@PostMapping("/emp")
	public Employee addEmp(@RequestBody Employee employee) {
		this.empservice.addEmployeeById(employee);
		return employee;
	}
	
	@PutMapping("/emp/{Id}")
	public Employee update(@RequestBody Employee employee,@PathVariable("Id") int Id) {
		this.empservice.updateEmployeeById(employee, Id);
		return employee;
	}
	
	@DeleteMapping("/emp/{Id}")
	public void delete(@PathVariable("Id") int Id) {
		this.empservice.deleteEmployeeById(Id);
	}
}
