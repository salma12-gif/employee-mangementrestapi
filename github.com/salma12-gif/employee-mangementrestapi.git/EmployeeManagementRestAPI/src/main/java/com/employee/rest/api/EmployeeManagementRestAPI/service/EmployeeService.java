package com.employee.rest.api.EmployeeManagementRestAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.rest.api.EmployeeManagementRestAPI.entity.Employee;
import com.employee.rest.api.EmployeeManagementRestAPI.repository.EmployeeRepository;
import com.employee.rest.api.EmployeeManagementRestAPI.userRepo.RoleRepository;
import com.employee.rest.api.EmployeeManagementRestAPI.userRepo.UserRepository;
import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.Roles;
import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.User;
import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.UserRequest;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public List<Employee> getEmployeeListData(){
		List<Employee> empList = new ArrayList<Employee>();

		repo.findAll().forEach(empList::add);
		return empList;
	}

	public List<Employee> getEmployeeByFirstNameList(String fname) {
		List<Employee> empList = repo.getEmployeeDataByFirstName(fname);
		return empList;
	}
			
	public Employee getEmployeeListDataById(int id) {
		Employee emp = repo.getEmployeeDataById(id);
		return emp;
	}
			
	
	public String deleteEmployeeById( int id ) {
		String str = "Deleted Employee id - ";
		
		repo.deleteById(id);
		
		
		return str;
	}

	public List<Employee> getEmployeesSortedByFirstNameData() {
		
		return repo.getEmployeeDataSortedBFiyrstName();
	}

	public UserRequest addUser(UserRequest userRequest) {
		String uname=userRequest.getUsername();
		String pwd=userRequest.getPassword();
		List<Roles> roleList = userRequest.getRoles();
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);		
		Roles roles = new Roles();
		for(Roles role : roleList) {
			roles.setId(role.getId());
			roles.setName(role.getName());
		}
		userRepo.save(user);
		roleRepo.save(roles);
		return userRequest;
	}

	public Roles addNewRoles(Roles roles) {
		
		return roleRepo.save(roles);
	}

	public Employee updateEmployeeData(int id,Employee emp) {
		Optional<Employee> empData = repo.findById(id);
		Employee e = empData.get();
		if(empData.isPresent()) {			
			e.setFirstName(emp.getFirstName());
			e.setLastName(emp.getLastName());
			e.setEmail(emp.getEmail());
		}
		repo.save(e);
		
		return e;
	}


	
	
}
