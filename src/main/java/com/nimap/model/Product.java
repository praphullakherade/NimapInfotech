package com.nimap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


@Entity
public class Product {
	
	@Id
	@SequenceGenerator(name = "product", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
	@Column(name="productid")
	private long productId;
	
	@Column(name="productname")
    @NotNull(message="product name is must")
	private String productName;
	
	@Column(name="productcost")
	@NotNull(message="product cost is must")
	private int productCost;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
	private Category category;
	
	
	public Product() {
		super();
	
	}

	public Product(long productId, @NotNull(message = "product name is must") String productName,
			@NotNull(message = "product cost is must") int productCost, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
