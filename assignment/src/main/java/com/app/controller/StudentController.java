package com.app.controller;

import javax.validation.Valid;

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

import com.app.dto.StudentDTO;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<?> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudent(@PathVariable Long studentId){
		return ResponseEntity.ok(studentService.getStudent(studentId));
	}
	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody @Valid StudentDTO studentDTO ){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO)
	{
		return ResponseEntity.ok(studentService.updateStudent(studentDTO));
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(studentId));
	}
	
	
}
