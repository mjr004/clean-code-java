package com.clean.code.solid.srp.refactored;

import com.clean.code.exceptions.BookPersistenceException;

public interface BookPersistence {
	public void save(Book book) throws BookPersistenceException; 
}
