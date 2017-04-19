package com.team.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByNameContaining(String q);
	
/*	@Query("select product from product product where product.id= :id")
	Product findByID_a(@Param("id") int id);*/
}
