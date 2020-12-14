package com.vr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vr.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	User findByPassword(String password);
}
