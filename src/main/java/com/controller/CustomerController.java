package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ProductNotFoundException;
import com.model.Delivery;
import com.model.Product;
import com.model.User;
import com.service.Deliveryservice;
import com.service.ProductService;
import com.service.Userservice;

@RestController
@CrossOrigin
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Deliveryservice deliveryservice;
	
	@PostMapping(value = "register")
	public User registerUser(@Valid @RequestBody User user) throws Exception {
		return userservice.registerUser(user);
	}
	
	@GetMapping(value = "login/{email}/{password}")
	public User loginUser(@PathVariable("email") String email,@PathVariable("password") String password) throws Exception {
		return userservice.loginUser(email, password);
	}
	@GetMapping(value = "getuserbyID/{id}")
	public User getuserbyID(@PathVariable("id") int id) {
		return userservice.getuserbyID(id);
	}

	
	@GetMapping(value = "getAllProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping(value = "getProductById/{pid}")
	public Product getProductById(@PathVariable("pid") int pid) throws Exception {
			return productService.getProductById(pid);
	}
	
	@PutMapping(value = "AddTocart/{uid}/{pid}")
	public User AddTocart(@PathVariable("uid") int uid,@PathVariable("pid") int pid) throws Exception {
		return userservice.Addtocart(uid, pid);
	}
	
	@PutMapping(value = "removeFromcart/{uid}/{pid}")
	public User RemoveFromCart(@PathVariable("uid") int uid,@PathVariable("pid") int pid) throws Exception {
		return userservice.Removefromcart(uid, pid);
	}
	
	@PostMapping(value = "ckeckout/{uid}")
	public User Checkout(@PathVariable("uid") int uid) throws Exception {
		return userservice.Checkout(uid);
	}
	
	@GetMapping(value = "UserOrderHistory/{uid}")
	public List<Delivery> getAllUserOrderHistory(@PathVariable("uid") int uid){
		return deliveryservice.findAllUserOrders(uid);
	}
	
	@PutMapping(value = "AddFeedback/{did}/{feedback}")
	public Delivery AddFeedback(@PathVariable("did") int did, @PathVariable("feedback") String feedback) throws Exception {
		return deliveryservice.AddFeedback(did, feedback);
	}
	
	
	

}
