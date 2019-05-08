package com.capgemini.product.service;

import com.capgemini.product.entity.Product;

public interface ProductService {

	Product addNew(Product product);

	Product getById(int productId);

	Product update(int productId, String productName, int productQuantity);

	void delete(int productId);

}
