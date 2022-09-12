package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.global.GlobalData;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		List<Category> allCategory = this.categoryService.getAllCategory();
		List<Product> allProduct = this.productService.getAllProduct();

		model.addAttribute("categories", allCategory);
		model.addAttribute("products", allProduct);
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		List<Category> allCategory = this.categoryService.getAllCategory();
		List<Product> allProductsByCategory = this.productService.getAllProductsByCategory(id);

		model.addAttribute("categories", allCategory);
		model.addAttribute("products", allProductsByCategory);
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		Product product = this.productService.getProductById(id).get();

		model.addAttribute("product", product);
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";
	}

}
