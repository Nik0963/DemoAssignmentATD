package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.app.dto.ApiResponseDTO;
import com.app.dto.StudentDTO;
import com.app.entities.Students;

public interface StudentService {

	 List<StudentDTO> getAllStudents();

	Optional<Students> getStudent(Long studentId);

	ApiResponseDTO addStudent(@Valid StudentDTO studentDTO);

	ApiResponseDTO deleteStudent(Long studentId);

	ApiResponseDTO updateStudent(StudentDTO studentDTO);

}
