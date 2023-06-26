package com.greatlearning.pojo;

public class Employee {
	
	private String firstname;
	private String lastname;
	private String department;
	private String[] technologies;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String[] getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}

}
