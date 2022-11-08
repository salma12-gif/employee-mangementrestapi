package com.employee.rest.api.EmployeeManagementRestAPI.userRoles;

import java.util.List;

public class UserRequest {
	private String username;
	private String password;
	private List<Roles> roles;
	
	public UserRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRequest(String username, String password, List<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
}
