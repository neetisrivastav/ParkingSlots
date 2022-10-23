package com.students.event.controller;

import com.students.event.studentModel.User;
import com.students.event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.students.event.studentModel.Students;
import com.students.event.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserRepository userRepository;
	@PostMapping("/save-update-students")
	public String saveStudent(@RequestBody Students student) {
		studentService.saveStudent(student);
		return "successfully inserted or updated";
	}

	@GetMapping("/students")
	public List<Students> listStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/delete-students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "deleted successfully";
	}

	@PostMapping("/save-update-users")
	public String saveUser(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return "successfully inserted or updated user";
	}
}
