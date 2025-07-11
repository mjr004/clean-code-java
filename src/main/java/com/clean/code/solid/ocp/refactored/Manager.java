package com.clean.code.solid.ocp.refactored;

public class Manager extends Employee{

	private String bonus;
	
	public Manager(String fullName, Integer salary) {
		super(fullName, salary);
	}
	
	public String getBonus() {
		return bonus;
	}

}