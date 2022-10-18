package com.students.event.service;

import java.util.List;

import com.students.event.model.Students;


public interface StudentService {
	List<Students> getAllStudents();

	Students saveStudent(Students student);

	Students getStudentById(Long id);

	void deleteStudentById(Long id);
}
