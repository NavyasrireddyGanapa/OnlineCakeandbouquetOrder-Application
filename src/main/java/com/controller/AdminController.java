package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Delivery;
import com.model.Product;
import com.model.User;
import com.service.Deliveryservice;
import com.service.ProductService;
import com.service.Userservice;

@RestController
@CrossOrigin
@RequestMapping("Admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Deliveryservice deliveryservice;
	
	@Autowired
	private Userservice userservice;
//	adding products to the Database ;
	@PostMapping(value = "addProduct")
	public Product addproduct( @RequestBody Product product) throws Exception {
		return productService.addProduct(product);
	}
	@GetMapping(value = "getAllUsers")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@GetMapping(value = "showAllFeedbacks")
	public List<Delivery> getallDeliveries(){
		return deliveryservice.getallDeliveries();
	}
	@PutMapping(value = "updateProductPrice/{pid}/{price}")
	public Product updateProductPrice(@PathVariable("pid") int pid,@PathVariable("price") long price ) throws Exception {
		return productService.updateProductPrice(pid,price);
	}
	@DeleteMapping(value = "deleteProductById/{pid}")
	public Product deleteProductById(@PathVariable("pid") int pid) throws Exception {
		return productService.deleteProductById(pid);
	}
	//@DeleteMapping(value = "deleteProductById/{pid}")
	//public void deleteProductById(@PathVariable int pid) throws Exception {
		//  productService.deleteProductById(pid);
	//}
	
//	@GetMapping(value = "GetAllProducts")
//	public List<Product> GetAllProducts(){
//		return productService.getAllProducts();
//	}
	
}
