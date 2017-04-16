package com.team.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByNameContaining(String q);
}
