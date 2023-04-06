package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ProductNotFoundException;
import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product)  {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product updateProductPrice(int pid, long price) throws Exception {
		Product product = productRepository.findById(pid).get();
		if(product != null) {
			product.setPrice(price);
			return productRepository.save(product);
			
		}else {
			throw new Exception("Product Not Exist");
		}
	}
	public Product deleteProductById(int pid) throws Exception {
		Product product =productRepository.getById(pid);
		//Product product =productRepository.findById(pid).get();
		if(product!=null) {
			productRepository.deleteById(product.getId());
			return product;
		}
		throw new Exception("Product Not Found");
	}
	//public void deleteProductById(int pid) throws Exception {
		//Product product =productRepository.getById(pid);
		//productRepository.delete(product);
	//}
	public Product getProductById(Integer pid) throws ProductNotFoundException{
		Product p;
		if(productRepository.findById(pid).isEmpty()) {
			throw new ProductNotFoundException("Product Not found");
		}
		else {
			p=productRepository.findById(pid).get();
		}
		return p;
	}

}
