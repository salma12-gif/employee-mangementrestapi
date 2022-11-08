package com.employee.rest.api.EmployeeManagementRestAPI.userRepo;

import org.springframework.data.repository.CrudRepository;

import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
