package com.spring.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.web.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
