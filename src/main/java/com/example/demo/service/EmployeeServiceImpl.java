package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int Id) {
		Employee employee = null;
		try {
			employee = empRepository.findById(Id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee addEmployeeById(Employee employee) {
        Employee eobj = empRepository.save(employee);
		return eobj;
	}

	@Override
	public void updateEmployeeById(Employee employee, int Id) {
		empRepository.deleteById(employee.getEmpId());
        employee.setEmpId(Id);
        empRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int Id) {
       empRepository.deleteById(Id);		
	}

}
