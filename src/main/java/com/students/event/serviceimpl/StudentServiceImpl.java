package com.students.event.serviceimpl;

import java.util.List;

import com.students.event.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.event.studentModel.Students;
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
