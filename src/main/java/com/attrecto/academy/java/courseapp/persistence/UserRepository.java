package com.attrecto.academy.java.courseapp.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attrecto.academy.java.courseapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//IgnoreCase kulcsszó biztosítja, hogy a lekérdezés egyezései a kis- és nagybetűket figyelmen kívül hagyják
	public Optional<User> findByNameIgnoreCase(String name);
}
