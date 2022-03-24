package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.nimap.model.Product;

public interface ProductService {
	
	public String addProduct(Product product);
	public String updateProduct(Product product);
	public String deleteProduct(long productId);
	public List<Product> getAllProduct();
	public Product getProductById(long productId);
	public List<Product> getProductByName(String productName);
	Page<Product> findProductsWithPagination(int offset, int pageSize);
	Page<Product> searchProductsWithPaginationAndSorting(Product product, long pageNo, int pageSize);
		
}
