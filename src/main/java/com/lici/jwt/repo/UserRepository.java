package com.lici.jwt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lici.jwt.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findUserByUsername(String username); 
}
