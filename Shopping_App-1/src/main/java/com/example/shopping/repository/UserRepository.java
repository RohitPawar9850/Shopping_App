package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods if needed
}