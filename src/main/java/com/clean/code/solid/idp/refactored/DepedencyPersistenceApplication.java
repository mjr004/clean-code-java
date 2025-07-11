package com.clean.code.solid.idp.refactored;

import com.clean.code.solid.idp.factory.EmployeeInMemoryPersistenceFactory;

public class DepedencyPersistenceApplication {

	public static void main(String[] args) {
		Company company = new Company(
				new EmployeeInMemoryPersistenceFactory());
	}
}
