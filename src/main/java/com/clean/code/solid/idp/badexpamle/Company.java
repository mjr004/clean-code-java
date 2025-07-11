package com.clean.code.solid.idp.badexpamle;

import java.util.List;

public class Company {

    private EmployeePersistence persistence;

    public Company() {
        persistence = new EmployeeInMemoryPersistence();
    }

    public List<Employee> getEmployee() {
        return persistence.findAll();
    }

    public void addEmployee(Employee employee) {
        persistence.save(employee);
    }
}