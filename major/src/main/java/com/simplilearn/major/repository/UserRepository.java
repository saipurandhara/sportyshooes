package com.simplilearn.major.repository;

import java.util.Optional;

import com.simplilearn.major.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User>findUserByEmail(String email);

}
