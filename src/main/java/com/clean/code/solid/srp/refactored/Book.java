package com.clean.code.solid.srp.refactored;

import java.util.List;


public class Book {
	
	public static final String BOOK_DIRECTORY_PATH = "/tmp";
	  
	private String title;
	private String author;
	private List<Page> pages;
	private Page currentPage;
	
	public Book(String title, String author, List<Page> pages, Page currentPage) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.currentPage = this.pages.get(0);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Page getCurrentPage() {
		return currentPage;
	}
	
	public void turnPage() {
        Integer nextPageIndex = currentPage.getNumber();
        if (nextPageIndex <= pages.size()) {
            currentPage = pages.get(nextPageIndex);
        }
    }

    public void turnPageBack() {
        Integer previousPageIndex = currentPage.getNumber() - 2;
        if (previousPageIndex >= 0) {
            currentPage = pages.get(previousPageIndex);
        }
    }
    
    public List<Page> getPages() {
		return pages;
	}
}