package com.vincent.spring.rmi.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;

import com.vincent.spring.rmi.common.bean.Student;
import com.vincent.spring.rmi.common.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	@Autowired
	public StudentController(RmiProxyFactoryBean rmiService) {
		studentService = (StudentService) rmiService.getObject();
	}

	public Student get(int id) {
		return studentService.get(id);
	}

	public void save() {
		Student student = new Student(1, "lilei");
		studentService.save(student);
	}
}
