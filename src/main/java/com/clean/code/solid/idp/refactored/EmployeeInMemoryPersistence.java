package com.clean.code.solid.idp.refactored;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInMemoryPersistence implements EmployeePersistence{

    private List<Employee> employees;

    public EmployeeInMemoryPersistence() {
    	employees = new ArrayList<Employee>();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public void save(Employee employee) {
    	employees.add(employee);
    }
}