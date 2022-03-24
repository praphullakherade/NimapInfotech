package com.nimap.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nimap.exception.ProductNotFoundException;
import com.nimap.model.Product;
import com.nimap.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public String addProduct(Product product) {
		Optional<Product> product1 = repository.findById(product.getProductId());
		if(!product1.isPresent()) {
			repository.save(product);
			return "Successfully inserted Product and product id is "+product.getProductId();
		}
		else{
			throw new ProductNotFoundException(product.getProductId());
		}
		
	}

	@Override
	public String updateProduct(Product product) {
		Optional<Product> product1 = repository.findById(product.getProductId());
		if(product1.isPresent()) {
			Product currentproduct = product1.get();
			currentproduct.setProductName(product.getProductName());
			currentproduct.setProductCost(product.getProductCost());
			repository.save(currentproduct);
			return "Successfully Updated";
		}
		else {
			throw new ProductNotFoundException(product.getProductId());
		}
	}

	@Override
	public String deleteProduct(long productId) {
		Optional<Product> product1 = repository.findById(productId);
		if(product1.isPresent()) {
			repository.deleteById(productId);;
			return "Successfully Deleted ";
		}
		else{
			throw new ProductNotFoundException(productId);
		}
	}

	@Override
	public List<Product> getAllProduct() {
	
		return repository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		Optional<Product> product= repository.findById(productId);
		if(product.isPresent()) {
			
			return product.get();
		}
		else { throw new ProductNotFoundException(productId);}
	}

	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> product= repository.getProductName(productName);
		if(product.size()!=0) {
			return product;
		}
		else { throw new ProductNotFoundException(productName);}
	}
	
	
	@Override
	public Page<Product> searchProductsWithPaginationAndSorting(Product product, long pageNo, int pageSize) {
		
		PageRequest firstPageWithTwoElements= PageRequest.of(0, 3,Sort.by("productName"));
		Page<Product> page=repository.findAll(firstPageWithTwoElements);
		return page;
	}
	
	@Override
    public Page<Product> findProductsWithPagination(int offset,int pageSize){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

}
