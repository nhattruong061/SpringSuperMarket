package com.team.service;

import java.util.List;

import com.team.domain.ProductRating;

public interface ProductRatingService {

	Iterable<ProductRating> findAll();
	
	List<ProductRating> search(int Id);
	
	ProductRating findOne(int id);
	
	void save(ProductRating productRating);
	
	void delete(int id);
}
