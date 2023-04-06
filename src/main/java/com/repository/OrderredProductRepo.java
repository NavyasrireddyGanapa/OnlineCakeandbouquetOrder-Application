package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OrderedProduct;

@Repository
public interface OrderredProductRepo extends JpaRepository<OrderedProduct, Integer>{

}
