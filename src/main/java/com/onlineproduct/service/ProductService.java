package com.onlineproduct.service;

import java.util.List;

import com.onlineproduct.entity.Product;
import com.onlineproduct.exception.ResourceNotFoundException;

public interface ProductService {

	Product save(Product product);

	List<Product> getAllProduct();

	Product getProductById(int id) throws ResourceNotFoundException;

	Product deleteProductById(int id) throws ResourceNotFoundException;

	Product update(Product product) throws ResourceNotFoundException;
}
