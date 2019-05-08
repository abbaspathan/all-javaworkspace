package com.capgemini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.product.dao.ProductDao;
import com.capgemini.product.entity.Product;
import com.capgemini.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public Product addNew(Product product) {
		return dao.save(product);
	}

	@Override
	public Product getById(int productId) {
		
		return dao.findById(productId).get();
	}

	@Override
	public Product update(int productId,String productName,int productQuantity) {
		Product product=dao.findById(productId).get();
		
		product.setProductName(productName);
		product.setProductQuantity(productQuantity);
		
		return dao.save(product);		
	}
	
	@Override
	public void delete(int productId) {
		dao.deleteById(productId);;
	}

}
