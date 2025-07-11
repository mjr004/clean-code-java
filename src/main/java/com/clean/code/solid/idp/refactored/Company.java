package com.clean.code.solid.idp.refactored;

import java.util.List;

import com.clean.code.solid.idp.factory.EmployeePersistencFactory;

public class Company {

    private EmployeePersistence persistence;

    public Company(EmployeePersistencFactory employeePersistencFactory) {
        persistence = new EmployeeInMemoryPersistence();
    }

    public List<Employee> getEmployee() {
        return persistence.findAll();
    }

    public void addEmployee(Employee employee) {
        persistence.save(employee);
    }
}