package com.employee.rest.api.EmployeeManagementRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.rest.api.EmployeeManagementRestAPI.entity.Employee;
import com.employee.rest.api.EmployeeManagementRestAPI.service.EmployeeService;
import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.Roles;
import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.UserRequest;

@RestController
@RequestMapping("/employee/restApi")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addRoles")
	public Roles addUser(@RequestBody Roles roles) {
		
		Roles newRoles = service.addNewRoles(roles);
		
		return newRoles;
	}
	
	@PostMapping("/addUser")
	public UserRequest addUser(@RequestBody UserRequest userRequest) {
		
		UserRequest userRequestData = service.addUser(userRequest);
		
		return userRequestData;
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		Employee employee = service.addEmployee(emp);
		
		return employee;
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployeeList(){
		
		return service.getEmployeeListData();
		
	}
	
	@GetMapping("/getEmployeeByFirstName/{firstName}")
	public List<Employee> getEmployeeByFirstNameList(@PathVariable String firstName){
		
		return service.getEmployeeByFirstNameList(firstName);
		
	}
	
	@GetMapping("/getEmployeeSortedByFirstName")
	public List<Employee> getEmployeesSortedByFirstNameList(){
		
		return service.getEmployeesSortedByFirstNameData();
		
	}
	
	@PutMapping("/updateEmployeesById/{id}")
	public Employee updateEmployeesById(@PathVariable int id,@RequestBody Employee emp){
		
		return service.updateEmployeeData(id,emp);
		
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		
		return service.getEmployeeListDataById(id);
		
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable int id){
		String str = service.deleteEmployeeById(id);
		return str+id;
		
	}
}
