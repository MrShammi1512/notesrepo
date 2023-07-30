package com.student.Student_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.Notes;
import com.student.Student_Management.entity.User;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long> {
    
    List<Notes> findByUser(User user);
    
    // You can add additional query methods for specific requirements if needed
}
