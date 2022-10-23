package com.students.event.serviceimpl;

import com.students.event.repository.StudentRepository;
import com.students.event.service.StudentService;
import com.students.event.studentModel.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
