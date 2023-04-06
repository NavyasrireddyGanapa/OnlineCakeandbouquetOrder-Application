package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.exception.ProductNotFoundException;
import com.model.Product;
import com.repository.DeliveryRepository;
import com.repository.OrderredProductRepo;
import com.repository.ProductRepository;
import com.repository.UserRepository;
import com.service.ProductService;
import com.service.Userservice;



public class ProductserviceTest {
	@Mock
	private ProductRepository productRepository;
	@InjectMocks
	private ProductService productservice;
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testAddProduct() {
	    Product p = new Product();
	    p.setProductName("Test Product");
	    p.setPrice(10);
	    productRepository.saveAndFlush(p);
	    assertTrue(productRepository.findAll().size()==0);
	    
	}
	@Test
	public void testGetAllProducts() {
	    List<Product> products = productservice.getAllProducts();

	    assertNotNull(products);
	    assertTrue(products.size() > 0);
	}
	@Test
	//public void testupdateProductPrice() {
		//int id=1;
		//Product p=new Product(1, "PlumCake", 750, "https://food-images.files.bbci.co.uk/food/recipes/birthday_chocolate_24628_16x9.jpg");
		//Product updatedProduct=new Product(1, "PlumCake", 550, "https://food-images.files.bbci.co.uk/food/recipes/birthday_chocolate_24628_16x9.jpg");
	    //when(productRepository.getById(1).thenReturn()));
	//}
	public void testupdateProductPrice() throws Exception{
		    Product p = new Product();
		    p.setProductName("Plumcake");
		    p.setPrice(10);
		    Product savedProduct = productservice.addProduct(p);
		    long newPrice = 20;
		    Product updatedProduct = productservice.updateProductPrice(savedProduct.getId(), newPrice);
		    assertEquals(newPrice, updatedProduct.getPrice());
	}

	@Test
	public void testDeleteProductById() throws Exception {
		productRepository.deleteById(1);
		assertFalse(productRepository.getById(1)!=null);
	}
	@Test
	public void testGetProductById(){
		List<Product> products = productservice.getAllProducts();
	    assertNotNull(products);
	    assertFalse(products.size() > 0);
	}


	
	
}
