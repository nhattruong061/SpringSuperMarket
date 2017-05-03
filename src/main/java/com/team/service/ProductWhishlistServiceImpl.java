package com.team.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.ProductWhishlist;
import com.team.repository.ProductWhishlistRepository;

@Service
public class ProductWhishlistServiceImpl implements ProductWhishlistService{

	@Autowired
	private ProductWhishlistRepository productWhishlistRepository;
	
	@Override
	public Iterable<ProductWhishlist> findAll() {
		// TODO Auto-generated method stub
		return productWhishlistRepository.findAll();
	}

	@Override
	public List<ProductWhishlist> search(int Id_product) {
		// TODO Auto-generated method stub
		return productWhishlistRepository.findById(Id_product);
	}

	@Override
	public ProductWhishlist findOne(int id) {
		// TODO Auto-generated method stub
		return productWhishlistRepository.findOne(id);
	}

	@Override
	public void save(ProductWhishlist ProductWhishlist) {
		// TODO Auto-generated method stub
		productWhishlistRepository.save(ProductWhishlist);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productWhishlistRepository.delete(id);
	}

}
