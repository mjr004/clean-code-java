package com.clean.code.solid.idp.refactored;

import java.util.List;

public class EmployeeMysqlPersistence implements EmployeePersistence{

    public EmployeeMysqlPersistence(String url, String user, String password) {
    	/* conect to db */
    }

    public List<Employee> findAll() {
    	/* query to db */
        return null;
    }

    public void save(Employee employee) {
    	/* query to db */
    }
}