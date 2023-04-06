package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="userdetails")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(min = 5,message = "username should be min 5 chars")
	private String name;
	@NotEmpty
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Enter a valid emailaddress!")
	private String email;
	@NotEmpty
	@Size(min = 5,max = 10,message = "Password should be  min 5 chars")
	private String password;
	private String role;
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress userAddress;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private List<Product> cartlist;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, UserAddress userAddress, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userAddress = userAddress;
		this.cartlist = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	public List<Product> getCartlist() {
		return cartlist;
	}
	public void setCartlist(List<Product> cartlist) {
		this.cartlist = cartlist;
	}
	public void addOrder(Product product) throws Exception {
		if(cartlist == null ) {
			this.cartlist = new ArrayList<Product>();
		}
		if(cartlist.contains(product)) {
			throw new Exception("Product alreday Exist");
		}
		cartlist.add(product);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
