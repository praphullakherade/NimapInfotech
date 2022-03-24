package com.nimap.service;

import java.util.List;
import com.nimap.model.Category;

public interface CategoryService {
	
	public String addCategory(Category category);
	public String updateCategory(Category category);
	public String deleteCategory(long id);
	public List<Category> getAllCategory();
	
}
