package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.ProductRating;
import com.team.repository.ProductRatingRepository;

@Service
public class ProductRatingServiceImpl implements ProductRatingService{

	@Autowired
	private ProductRatingRepository productRatingRepository;
	
	@Override
	public Iterable<ProductRating> findAll() {
		// TODO Auto-generated method stub
		return productRatingRepository.findAll();
	}

	@Override
	public List<ProductRating> search(int Id_product) {
		// TODO Auto-generated method stub
		return productRatingRepository.findById(Id_product);
	}

	@Override
	public ProductRating findOne(int id) {
		// TODO Auto-generated method stub
		return productRatingRepository.findOne(id);
	}

	@Override
	public void save(ProductRating productRating) {
		// TODO Auto-generated method stub
		productRatingRepository.save(productRating);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRatingRepository.delete(id);
	}

}
