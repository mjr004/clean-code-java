package com.clean.code.solid.ocp.refactored;

import java.util.List;

public class Company {

    private EmployeePersistence persistence;

    public Company() {
        persistence = new ProgrammerMemoryPersistence();
    }

    public List<Employee> getEmployee() {
        return persistence.findAll();
    }

    public void addEmployee(Employee employee) {
        persistence.save(employee);
    }
}