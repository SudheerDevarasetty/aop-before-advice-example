package com.javatpoint.controller;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Account;
import com.javatpoint.model.Employee;
import com.javatpoint.service.AccountService;
import com.javatpoint.service.BankService;
import com.javatpoint.service.EmployeeService;

import lombok.RequiredArgsConstructor;  
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController   
{  
  
private final EmployeeService employeeService; 

private final  BankService bankService;

private final  AccountService accountService;
@GetMapping(value = "/add/employee")  
public Employee addEmployee(@RequestParam("empId") String empId, @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName)   
{  
return employeeService.createEmployee(empId, firstName, secondName);  
}  
@GetMapping(value = "/remove/employee")  
public String removeEmployee( @RequestParam("empId") String empId)   
{  
employeeService.deleteEmployee(empId);  
return "Employee removed";  
}  
@GetMapping(value = "/checkBalance")  
public String checkBalance( @RequestParam("accNum") String accNum)   
{  
	bankService.displayBalance(accNum);  
return "Balance Displayed in the server console";  
}
@GetMapping(value = "/getAccount")  
public ResponseEntity<Account> getAccountDetails( @RequestParam("cusNum") String cusNum) throws Exception   
{  
	return new ResponseEntity<Account>(
			accountService.getAccountByCustomerId(cusNum), HttpStatus.OK); 

}
}