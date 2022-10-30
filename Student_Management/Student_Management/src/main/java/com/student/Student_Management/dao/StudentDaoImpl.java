package com.student.Student_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.Student_Management.entity.Student;
import com.student.Student_Management.exception.ReSourceNotFoundException;
import com.student.Student_Management.repo.StudentRepo;

@Service
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public List<Student> getAllStudents() {
		return this.studentRepo.findAll();
	}

	@Override
	public Student addStudents(Student student) {
		// TODO Auto-generated method stub
		 this.studentRepo.save(student);
		 return student;
	}

	@Override
	public ResponseEntity<Student> getStudentByRoll(long roll) {
		// TODO Auto-generated method stub
		Student st= studentRepo.findById(roll).orElseThrow(() -> new ReSourceNotFoundException("Student not exist with " +roll+" roll number "));
		 return ResponseEntity.ok(st);
	}

	@Override
	public ResponseEntity<Student> updateDetails(Student student, long roll) {
		// TODO Auto-generated method stub
		
		Student prev=studentRepo.findById(roll).orElseThrow(()-> new ReSourceNotFoundException("Student doesn't exist with "+roll +"roll number"));
		prev.setAge(student.getAge());
		prev.setFirst_name(student.getFirst_name());
		prev.setLast_name(student.getLast_name());
		Student new_st=this.studentRepo.save(prev);
		return ResponseEntity.ok(new_st);
	}

	@Override
	public String deleteStudent(long roll) {
		// TODO Auto-generated method stub
		List<Student> ls=studentRepo.findAll();
		Student prev=null;
		for( Student s : ls)
		{
			if(s.getRoll()==roll)
			{
				prev=s;
				break;
			}
		}
		if(prev==null) return "Details Not Found";
		else {this.studentRepo.delete(prev);
		return "Deleted";
		}
	}

	
	

}
