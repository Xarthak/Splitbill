package com.sarthak.split2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sarthak.split2.entity.Bill;
import com.sarthak.split2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 List<User> findByName(String name);
	 
	 
	 //test
	 //success
	 @Query(value="Select u from User u where u.email like %:email%")
	 List<User> findByemail(@Param("email")String email);
	 
	 
	 
	
	

}
