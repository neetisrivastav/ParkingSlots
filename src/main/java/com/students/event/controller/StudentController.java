package com.students.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.event.model.Students;
import com.students.event.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save-update-students")
	public String saveStudent(@RequestBody Students student) {
		studentService.saveStudent(student);
		return "successfully inserted or updated";
	}

	@GetMapping("/students")
	public List<Students> listStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/delete-students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "deleted successfully";
	}
}
