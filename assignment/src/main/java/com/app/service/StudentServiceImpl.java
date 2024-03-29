package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentDao;
import com.app.dto.ApiResponseDTO;
import com.app.dto.StudentDTO;
import com.app.entities.Students;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Students> students = studentDao.findAll();
		return students.stream().map(s -> mapper.map(s, StudentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Optional<Students> getStudent(Long studentId) {
		Optional<Students> student = studentDao.findById(studentId);
		return student;
	}

	@Override
	public ApiResponseDTO addStudent(@Valid StudentDTO studentDTO) {
		Students student = mapper.map(studentDTO, Students.class);
		studentDao.save(student);
		return new ApiResponseDTO("Student details added succesfully!");
	}

	@Override
	public ApiResponseDTO deleteStudent(Long studentId) {
		studentDao.deleteById(studentId);
		return new ApiResponseDTO("Student details deleted succesfully!");
	}

	@Override
	public ApiResponseDTO updateStudent(StudentDTO studentDTO) {
		Students student = studentDao.findById(studentDTO.getId()).orElseThrow();

		student.setCity(studentDTO.getCity());
		student.setEmail(studentDTO.getEmail());
		student.setName(studentDTO.getName());
		student.setMobileNumber(studentDTO.getMobileNumber());
		studentDao.save(student);

		return new ApiResponseDTO("Student details updated succesfully!");
	}

}
