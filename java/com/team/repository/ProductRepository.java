package com.team.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByNameContaining(String q);
	
	List<Product> findTop10ByType(int id);
	/*	@Query("select product from product product where product.id= :id")
	Product findByID_a(@Param("id") int id);*/
}
