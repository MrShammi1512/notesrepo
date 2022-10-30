package com.student.Student_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.Student_Management.entity.Student;


public interface StudentDao {
	public List<Student> getAllStudents();
	public Student addStudents(Student student);
	public ResponseEntity<Student> getStudentByRoll(long roll);
	public ResponseEntity<Student> updateDetails(Student student, long roll);
	public String deleteStudent(long roll);

}
