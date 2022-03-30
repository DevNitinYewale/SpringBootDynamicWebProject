package com.spring.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.entity.Student;
import com.spring.web.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studRepo;
	
	//Display all Student
	public List<Student> listAllStudent(){
		return studRepo.findAll();
	}
	
	//insert Student data
	public void saveStudent(Student student) {
		studRepo.save(student);
	}
	
	//Delete Student by id
	public Student getStudentByid(Integer id) {
		return studRepo.findById(id).get();
	}
	
	//delete Student data
	public void deleteStudent(Integer id) {
		studRepo.deleteById(id);
	}
	
}
