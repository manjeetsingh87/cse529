package com.jacoco.utility;

public enum Role {
	Professor("P"),
	Student("S"),
	Manager("M"),
	TechnicalLead("TL"),
	Admin("A");
	
	private String role;
	
	Role(String role) {
		if(null == role || role.length() == 0)
			throw new IllegalArgumentException("Invalid Role type entered. Role can be one among Professor, Student, Manager or TechnicalLead");
		
		this.role = role;
	}
	
	public String roleType() {
		return role;
	}
}
