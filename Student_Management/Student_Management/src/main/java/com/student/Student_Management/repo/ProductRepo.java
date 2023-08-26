package com.student.Student_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
