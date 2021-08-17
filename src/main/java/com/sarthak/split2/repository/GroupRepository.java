package com.sarthak.split2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.sarthak.split2.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
	
	

}
