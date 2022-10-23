package com.students.event.service;

import com.students.event.studentModel.Students;

import java.util.List;


public interface StudentService {
	List<Students> getAllStudents();

	Students saveStudent(Students student);

	Students getStudentById(Long id);

	void deleteStudentById(Long id);
}
