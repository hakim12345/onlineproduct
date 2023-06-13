package com.onlineproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineproduct.entity.Product;
import com.onlineproduct.exception.ResourceNotFoundException;
import com.onlineproduct.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product){
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws ResourceNotFoundException{
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("id") int id) throws ResourceNotFoundException{
		return new ResponseEntity<Product>(productService.deleteProductById(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product product) throws ResourceNotFoundException{
		return new ResponseEntity<Product>(productService.update(product), HttpStatus.OK);
	}
}
