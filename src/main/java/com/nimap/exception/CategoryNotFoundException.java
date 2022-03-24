package com.nimap.exception;

public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException(long id) {
		super("Could not find Category with category id "+id);
		
	}
	
}
