package com.student.Student_Management.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Student_Management.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
