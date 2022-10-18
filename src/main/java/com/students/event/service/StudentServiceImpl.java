package com.students.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.event.model.Students;
import com.students.event.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Students> getAllStudents() {
		return studentRepository.findAll();
	}

	public Students saveStudent(Students student) {
		return studentRepository.save(student);
	}

	public Students getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}


}
