package com.nimap.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nimap.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	
	@Query("select p from Product p where productName=?1")
	List<Product> getProductName(String productName);
	
	@Query(value="select * from product", nativeQuery=true)
    public List<Product> search(Product product, long pageNo, int pageSize);
	
}
