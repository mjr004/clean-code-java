package com.clean.code.solid.ocp.refactored;

public class Employee {
	 private String fullName;
	 private Integer salary;

	 public Employee(String fullName, Integer salary) {
		super();
		this.fullName = fullName;
		this.salary = salary;
	}

	public String getFullName() {
	        return fullName;
	 }

	 public Integer getSalary() {
	        return salary;
	 }
}
