package com.students.event.service;

import java.util.List;

import com.students.event.studentModel.Students;


public interface StudentService {
	List<Students> getAllStudents();

	Students saveStudent(Students student);

	Students getStudentById(Long id);

	void deleteStudentById(Long id);
}
