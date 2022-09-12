package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		List<Product> findAll = this.productRepository.findAll();
		return findAll;
	}
	
	public void addProduct(Product product) {
		this.productRepository.save(product);
	}
	
	public void removeProduct(long id) {
		this.productRepository.deleteById(id);
	}
	
	public Optional<Product> getProductById(long id){
		Optional<Product> findById = this.productRepository.findById(id);
		return findById;
	}
	
	public List<Product> getAllProductsByCategory(int id){
		List<Product> findAllByCategory_Id = this.productRepository.findAllByCategory_Id(id);
		return findAllByCategory_Id;
	}
}
