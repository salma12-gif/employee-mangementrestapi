package com.employee.rest.api.EmployeeManagementRestAPI.userRepo;

import org.springframework.data.repository.CrudRepository;

import com.employee.rest.api.EmployeeManagementRestAPI.userRoles.Roles;

public interface RoleRepository extends CrudRepository<Roles, Integer>{

}
