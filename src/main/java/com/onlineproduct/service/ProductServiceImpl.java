package com.onlineproduct.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineproduct.entity.Product;
import com.onlineproduct.exception.ResourceNotFoundException;
import com.onlineproduct.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) throws ResourceNotFoundException {
		Optional<Product> product = productRepo.findById(id);
		Supplier<ResourceNotFoundException> exceptionSupplier = () -> new ResourceNotFoundException(
				"Product details not found for product id: " + id);
		return product.orElseThrow(exceptionSupplier);
	}

	@Override
	public Product deleteProductById(int id) throws ResourceNotFoundException {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			productRepo.deleteById(id);
		}
		Supplier<ResourceNotFoundException> exceptionSupplier = () -> new ResourceNotFoundException(
				"Product details not found for product id: " + id);
		return product.orElseThrow(exceptionSupplier);
	}

	@Override
	public Product update(Product product) throws ResourceNotFoundException {
		Optional<Product> product1 = productRepo.findById(product.getProductId());
		if (product1.isPresent()) {
			productRepo.save(product);
		}
		Supplier<ResourceNotFoundException> exceptionSupplier = () -> new ResourceNotFoundException(
				"Product details not found for product id: " + product.getProductId());
		return product1.orElseThrow(exceptionSupplier);
	}
}
