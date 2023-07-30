package com.student.Student_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    
    User findByEmail(String email);
    
    // You can add additional query methods for specific requirements if needed
}
