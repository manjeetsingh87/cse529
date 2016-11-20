package com.jacoco.pojo;

import com.jacoco.utility.Role;

public class UserPOJO {
	private String name;
	private String id;
	private Role role;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = Role.valueOf(role);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
