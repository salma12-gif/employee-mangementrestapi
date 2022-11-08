package com.employee.rest.api.EmployeeManagementRestAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.rest.api.EmployeeManagementRestAPI.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("Select e from Employee e where e.id = :id")
	public Employee getEmployeeDataById(@Param("id") int id);
	
	@Query("Select e from Employee e where e.firstName = :fname")
	public List<Employee> getEmployeeDataByFirstName(@Param("fname") String fname);
	
	@Query("Select e from Employee e Order By firstName ASC")
	public List<Employee> getEmployeeDataSortedBFiyrstName();

}
