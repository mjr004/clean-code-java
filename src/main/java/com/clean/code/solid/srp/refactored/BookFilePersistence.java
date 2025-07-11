package com.clean.code.solid.srp.refactored;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.clean.code.exceptions.BookPersistenceException;

public class BookFilePersistence implements BookPersistence{

	 public void save(Book book) throws BookPersistenceException {
	        String bookFilePath =
	                Book.BOOK_DIRECTORY_PATH + "/" + book.getTitle() + "_" + new Date().getTime();
	        BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(bookFilePath));
				
				for (Page page : book.getPages()) {
		            writer.write("---- Page " + page.getNumber() + " ----");
		            writer.newLine();
		            writer.write(page.getContent());
		            writer.newLine();
		        }
		        writer.close();
			} catch (IOException e) {
				throw new BookPersistenceException();
			}
	        
	    }
}
