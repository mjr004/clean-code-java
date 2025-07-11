package com.clean.code.solid.idp.badexpamle;

import java.util.List;

public interface EmployeePersistence {
	 public List<Employee> findAll();
	 public void save(Employee employee);
}
