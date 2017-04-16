package com.team.service;

import java.util.List;

import com.team.domain.Product;

public interface ProductService {
	

    Iterable<Product> findAll();

    List<Product> search(String q);

    Product findOne(int id);

    void save(Product contact);

    void delete(int id);

}
