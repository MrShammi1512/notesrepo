package com.student.Student_Management.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Student_Management.dao.StudentDao;
import com.student.Student_Management.entity.Student;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	// for getting details of all students
	//private StudentRepo studentRepo;
	@Autowired
	private StudentDao studentDao;
	
	
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		return this.studentDao.getAllStudents();
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student)
	{
		return this.studentDao.addStudents(student);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable long id)
	{
		return  this.studentDao.getStudentByRoll(id);
	}
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateDetails(@RequestBody Student student,@PathVariable long roll )
	{
		return this.studentDao.updateDetails(student,roll);
	}
	
	@DeleteMapping("/students/{roll}")
	public String deleteStudent(@PathVariable long roll)
	{
		return studentDao.deleteStudent(roll);
	}
	
	

}
