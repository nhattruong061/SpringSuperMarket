package com.team.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.team.domain.ProductWhishlist;

public interface ProductWhishlistRepository extends CrudRepository<ProductWhishlist, Integer>{

	List<ProductWhishlist> findById(int Id_product);
	
}