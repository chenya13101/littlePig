package com.vincent.spring.rmi.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vincent.spring.rmi.client.config.ClientConfig;
import com.vincent.spring.rmi.client.controller.StudentController;
import com.vincent.spring.rmi.common.bean.Student;

public class ClientMain {
	@Test
	public void clientTest() {
		try {
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientConfig.class);
			// StudentService studentService = (StudentService)
			// applicationContext.getBean("studentService");
			StudentController studentController = (StudentController) applicationContext
					.getBean(StudentController.class);
			studentController.save();
			Student student = studentController.get(1);

			System.out.println("student = " + student);
			assertNotNull(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
