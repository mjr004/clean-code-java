package com.clean.code.solid.ocp.refactored;

import java.util.ArrayList;
import java.util.List;

public class ProgrammerMemoryPersistence implements EmployeePersistence{

    private List<Employee> employees;

    public ProgrammerMemoryPersistence() {
    	employees = new ArrayList<Employee>();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public void save(Employee employee) {
    	employees.add(employee);
    }
}