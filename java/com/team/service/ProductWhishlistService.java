package com.team.service;

import java.util.List;

import com.team.domain.ProductWhishlist;

public interface ProductWhishlistService {

	Iterable<ProductWhishlist> findAll();
	
	List<ProductWhishlist> search(int Id);
	
	ProductWhishlist findByIdProductAndIdUser( int idProduct,int idUser);
	
	ProductWhishlist findOne(int id);
	
	void save(ProductWhishlist ProductWhishlist);
	
	void delete(int id);
}