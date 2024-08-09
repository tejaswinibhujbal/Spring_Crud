package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;


@SpringBootApplication
public class CrudEmployeeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(CrudEmployeeApplication.class, args);
		
		EmployeeService empService = context.getBean(EmployeeServiceImpl.class);
		 
	    Scanner sc=new Scanner(System.in);
	    
	    int empId,ch;
	    String empName;
	    float empSal;
	    boolean f=true;
	    while(f)
	    {
	    	System.out.println("1-Insert\n2-Delete\n3-Update\n4-Display\n5-Exit\nEnter Your Choice:");
	        ch=sc.nextInt();
	    	switch(ch)
	    	{
	    	case 1:
	    		System.out.println("Enter Employee Id:");
	    	    empId=sc.nextInt();
	    		System.out.println("Enter Employee Name:");
	    	    empName=sc.next();
	    		System.out.println("Enter Employee Salary:");
	    		 empSal=sc.nextFloat();
	    		empService.addEmployeeById(new Employee(empId,empName,empSal));
	    		break;
	    	case 2:
	    		System.out.println("Enter employee Id to delete record:");
	    		empId=sc.nextInt();
	    		empService.deleteEmployeeById(empId);
	    		break;
	    	case 3:
	    		System.out.println("Enter previous Id of employee:");
	    		empId=sc.nextInt();
	    		Employee emp=empService.getEmployeeById(empId);
	    		System.out.println("Enter new Id of Employee:");
	    		empId=sc.nextInt();
	    		empService.updateEmployeeById(emp, empId);
	    		break;
	    	case 4:
	    		List<Employee> elst=empService.getAllEmployees();
	    		for(Employee e:elst)
	    		{
	    			System.out.println(e);
	    		}
	    		break;
	    	case 5:
	    		f=false;
	    		break;
	    	default:
	    		System.out.println("Please enter Correct Value");
	    		break;
	    	}
	    }
	}

}


















