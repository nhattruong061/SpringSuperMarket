package com.team.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.team.domain.ProductRating;

public interface ProductRatingRepository extends CrudRepository<ProductRating, Integer>{

	List<ProductRating> findById(int Id_product);
	
}
