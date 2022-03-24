package com.nimap.exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(long productId) {
		super("Could not find Product with product id "+productId);
	}

	public ProductNotFoundException(String productName) {
		super("Could not find Product with product name "+productName);	
	}

}
