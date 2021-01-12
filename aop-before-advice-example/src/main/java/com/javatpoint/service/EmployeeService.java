package com.javatpoint.service;

import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;

@Service
public class EmployeeService {

	public Employee createEmployee(String empId, String firstName, String secondName) {
		
		Employee emp = new Employee();  
		emp.setEmpId(empId);  
		emp.setFirstName(firstName);  
		emp.setSecondName(secondName);  
		return emp;  
	}

	public void deleteEmployee(String empId) {
		
		System.out.println("Deleting the employee with ID"+ empId);
	}

}
