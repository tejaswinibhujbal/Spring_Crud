package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int Id);
	public Employee addEmployeeById(Employee employee);
	public void updateEmployeeById(Employee employee,int Id);
	public void deleteEmployeeById(int Id);
	
}
