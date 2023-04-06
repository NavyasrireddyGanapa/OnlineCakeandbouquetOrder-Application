package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String feedback;
	private String deliveryStatus;
	private long total;
	@CreatedDate
	private LocalDate orderCreatedAt;
	private int userid;
	@OneToMany
	@JoinColumn(name = "orderId")
	private List<OrderedProduct> products;
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(String feedback, LocalDate orderCreatedAt, List<OrderedProduct> products,String deliveryStatus) {
		super();
		this.feedback = feedback;
		this.orderCreatedAt = orderCreatedAt;
		this.products = products;
		this.deliveryStatus=deliveryStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public LocalDate getOrderCreatedAt() {
		return orderCreatedAt;
	}
	public void setOrderCreatedAt(LocalDate orderCreatedAt) {
		this.orderCreatedAt = orderCreatedAt;
	}
	public List<OrderedProduct> getProducts() {
		return products;
	}
	public void setProducts(List<OrderedProduct> products) {
		this.products = products;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public void Addproduct(OrderedProduct orderedProduct) {
		if(products == null) {
			this.products = new ArrayList<OrderedProduct>();
		}
		this.products.add(orderedProduct);
		
	}
	
	
	
	

}
