package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

	List<Delivery> findAllByUserid(int uid);

}
