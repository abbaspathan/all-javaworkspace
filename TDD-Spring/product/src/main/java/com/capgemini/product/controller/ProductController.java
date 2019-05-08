package com.capgemini.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.product.entity.Product;
import com.capgemini.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@RequestMapping("/")
	public @ResponseBody String createProduct() {

		Product product = new Product(101, "mobile", 10);

		productService.addNew(product);
		return "success";
	}

	@GetMapping
	@RequestMapping("/detail/{productId}")
	public @ResponseBody Product getDetailsById(@PathVariable int productId) {

		return productService.getById(productId);

	}

	@PutMapping
	@RequestMapping("/update/{productId}/{productName}/{productQuantity}")
	public @ResponseBody Product updateProduct(@PathVariable int productId, @PathVariable String productName,
			@PathVariable int productQuantity) {

		return productService.update(productId, productName, productQuantity);

	}

	@DeleteMapping
	@RequestMapping("/delete/{productId}")
	public @ResponseBody String deleteProduct(@PathVariable int productId) {

		productService.delete(productId);
		return "isok";

	}

}
