package com.clean.code.solid.idp.factory;

import com.clean.code.solid.idp.refactored.EmployeeInMemoryPersistence;
import com.clean.code.solid.idp.refactored.EmployeePersistence;

public class EmployeeInMemoryPersistenceFactory implements EmployeePersistencFactory {

	@Override
	public EmployeePersistence getEmployeePersistence() {
		return new EmployeeInMemoryPersistence();
	}

}
