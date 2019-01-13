package com.telusko.bank.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> 
{	
	List<AuthGroup> findByUsername(String username);
}
