package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Category;
import com.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		List<Category> findAll = this.categoryRepository.findAll();
		return findAll;
	}
	
	public void addCategory(Category category) {
		this.categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		this.categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id) {
		Optional<Category> findById = this.categoryRepository.findById(id);
		return findById;
	}

}
