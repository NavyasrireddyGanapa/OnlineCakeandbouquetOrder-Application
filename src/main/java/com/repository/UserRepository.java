package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select m from User m where m.email = :email and m.password = :password ")
	User authenticateuser(@Param("email") String email, @Param("password") String password);

	User findByEmail(String email);

}
