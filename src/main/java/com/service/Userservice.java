package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Delivery;
import com.model.OrderedProduct;
import com.model.Product;
import com.model.User;
import com.repository.DeliveryRepository;
import com.repository.OrderredProductRepo;
import com.repository.ProductRepository;
import com.repository.UserRepository;

@Service
public class Userservice {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private OrderredProductRepo orderredProductRepo;
	
//	to register user
	public User registerUser(User user) throws Exception {
		user.setRole("ROLE_DELIVERY");
		User user2 = userRepository.findByEmail(user.getEmail());
		if(user2 == null) {
			return userRepository.save(user);
		}
		throw new Exception("User Already Exist with "+user.getEmail());
	}
	
//	to login 
	public User loginUser(String email,String Password) throws Exception {
		User user = userRepository.authenticateuser(email, Password);
		if(user != null) {
			return user;
		}
		throw new Exception("Wrong Credentials");
	}
	
//	addtocart
	public User Addtocart(int uid,int pid) throws Exception {
		User user = userRepository.findById(uid).get();
		if(user != null) {
			Product product = productRepository.findById(pid).get();
			if(product != null) {
				user.addOrder(product);
				userRepository.save(user);
				return user;
			}
			else {
				throw new Exception("Product Not Exist");
			}
		}else {
			throw new Exception("User Not Exist");
		}
		
	}
	
	public User Removefromcart(int uid,int pid) throws Exception {
		User user = userRepository.findById(uid).get();
		if(user != null) {
			Product product = productRepository.findById(pid).get();
			if(product != null) {
				user.getCartlist().remove(product);
				userRepository.save(user);
				return user;
			}else {
				throw new Exception("Product Not Exist");
			}
		}else {
			throw new Exception("User Not Exist");
		}
	}
	
	public User Checkout(int uid) throws Exception {
		long total =0;
		User user = userRepository.findById(uid).get();
		if(user != null) {
			if(! user.getCartlist().isEmpty()) {
//				delivery details
				Delivery delivery = new Delivery();
				delivery.setDeliveryStatus("Order Shipped");
				delivery.setUserid(uid);
				delivery.setOrderCreatedAt(LocalDate.now());
//				deliveryRepository.save(delivery);
				for(Product e:user.getCartlist()) {
					total+=e.getPrice();
					OrderedProduct orderedProduct = new OrderedProduct(0, e.getProductName(), e.getPrice());
					delivery.Addproduct(orderedProduct);
					orderredProductRepo.save(orderedProduct);
//					delivery products 
					System.out.println(e.getProductName());
				}
				delivery.setTotal(total);
				deliveryRepository.save(delivery);
				user.getCartlist().clear();
				userRepository.save(user);
				return user;
			}else {
				throw new Exception("Oops !!  Your Cart is Empty");
			}
		}
		throw new Exception("User Not Exit");
		
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User getuserbyID(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
	
	

	
	
	

}
