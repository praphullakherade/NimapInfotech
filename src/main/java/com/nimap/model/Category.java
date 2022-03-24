package com.nimap.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


@Entity
public class Category {
	
	@Id
	@SequenceGenerator(name = "category", sequenceName = "category_sequence", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "category", strategy = GenerationType.SEQUENCE)
	@Column(name = "categoryid")
	private long categoryId;
	
	@NotNull(message="category name is must")
	@Column(name = "categoryname")
	private String categoryName;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;
	
	
	public Category() {
		super();
		
	}
	
	public Category(long categoryId, String categoryName, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;

	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
