package com.clean.code.solid.idp.factory;
 
import com.clean.code.solid.idp.refactored.EmployeeMysqlPersistence;
import com.clean.code.solid.idp.refactored.EmployeePersistence; 

public class EmployeeMsyqlPersistenceFactory implements EmployeePersistencFactory {

	@Override
	public EmployeePersistence getEmployeePersistence() {
		return new EmployeeMysqlPersistence(System.getProperty("url_db"), System.getProperty("user_db"), 
				System.getProperty("password_db")) ;
	}

}
