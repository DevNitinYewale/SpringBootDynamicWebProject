package com.spring.web.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.entity.Student;
import com.spring.web.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentService studService;
	
	//DISPLAY ALL RECORDS
	
	@GetMapping("/get")
	public List<Student> list(){
		return studService.listAllStudent();
	}
	
	// INSERT NEW RECORD
	
	@PostMapping("/")
	public String add(@RequestBody Student student) {
		studService.saveStudent(student);
		return "record inserted successfully..!";
	}
	
	// DISPLAY RECORD BY ID
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id){
		try {
			Student stud=studService.getStudentByid(id);
			return new ResponseEntity<Student> (stud, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Student> (HttpStatus.NOT_FOUND);
		}
	}
	
	//DELETE RECORD BY ID
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		try {
			studService.deleteStudent(id);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "record deleted";
	}

	//UPDATE RECORD
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id){
		try {
			//Student stud=studService.getStudentByid(id);
			student.setId(id);
			studService.saveStudent(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
}
