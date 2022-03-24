package com.nimap.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimap.exception.CategoryNotFoundException;
import com.nimap.model.Category;
import com.nimap.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public String addCategory(Category category) {
		Optional<Category> category1 = repository.findById(category.getCategoryId());
		if(!category1.isPresent()) {
			repository.save(category);
			return "Successfully inserted category and product id is "+category.getCategoryId();
		}
		else{ throw new CategoryNotFoundException(category.getCategoryId());}
		
	}

	@Override
	public String updateCategory(Category category) {
		Optional<Category> category1 = repository.findById(category.getCategoryId());
		if(category1.isPresent()) {
			Category currentcategory = category1.get();
			currentcategory.setCategoryName(category.getCategoryName());
			repository.save(currentcategory);
			return "Successfully Updated";
		}
		else { throw new CategoryNotFoundException(category.getCategoryId());}
		
	}

	@Override
	public String deleteCategory(long id) {
		Optional<Category> category1 = repository.findById(id);
		if(category1.isPresent()) {
			repository.deleteById(id);;
			return "Successfully Deleted ";
		}
		else{ throw new CategoryNotFoundException(id);}
		
	}

	@Override
	public List<Category> getAllCategory() {
	
		return repository.findAll();
	}

}
