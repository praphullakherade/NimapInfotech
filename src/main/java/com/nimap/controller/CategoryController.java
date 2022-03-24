package com.nimap.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nimap.model.Category;
import com.nimap.service.CategoryService;


@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping("/addcategory")
	public ResponseEntity<String> addCategory(@Valid @RequestBody Category category){
		String category1 = service.addCategory(category);
		return new ResponseEntity<String>(category1, HttpStatus.OK);
	}
	
	@PutMapping("/updatecategory/{id}")
	public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category){
		String category1 = service.updateCategory(category);
		return new ResponseEntity<String>(category1, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable long id){
		String category1 = service.deleteCategory(id);
		return new ResponseEntity<String>(category1, HttpStatus.OK);
	}
	
	@GetMapping("/getallcategory")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> category1 = service.getAllCategory();
		return new ResponseEntity<List<Category>>(category1, HttpStatus.OK);
	}

}
