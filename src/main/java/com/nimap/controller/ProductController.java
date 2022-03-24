package com.nimap.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nimap.model.Product;
import com.nimap.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(@Valid @RequestBody Product product){
		String product1 = service.addProduct(product);
		return new ResponseEntity<String>(product1, HttpStatus.OK);
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<String> updateProduct(@Valid @RequestBody Product product){
		String product1 = service.updateProduct(product);
		return new ResponseEntity<String>(product1, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		String product1 = service.deleteProduct(id);
		return new ResponseEntity<String>(product1, HttpStatus.OK);
	}
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> product1 = service.getAllProduct();
		return new ResponseEntity<List<Product>>(product1, HttpStatus.OK);
	}
	
	@GetMapping("/getproductbyid/{productId}")
	public ResponseEntity<Product> getEmployeeById(@PathVariable long productId){
		
		Product product= service.getProductById(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("getproductbyname/{productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String productName){
		
		List<Product> product= service.getProductByName(productName);
		return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	@GetMapping("/searchProductsWithPaginationAndSorting")
	public ResponseEntity<?> searchProductsWithPaginationAndSorting(Product product)
	{
		Page<Product> page=service.searchProductsWithPaginationAndSorting(product,0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(page,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/searchbypagination")
	public ResponseEntity<?> searchByPagination(Product product)
	{
		Page<Product> page=service.findProductsWithPagination(0, 4);
		ResponseEntity<?> response=new ResponseEntity<>(page,HttpStatus.OK);
		return response;
	}
}
