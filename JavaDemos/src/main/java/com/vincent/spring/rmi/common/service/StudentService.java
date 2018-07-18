package com.vincent.spring.rmi.common.service;

import org.springframework.stereotype.Service;

import com.vincent.spring.rmi.common.bean.Student;

public interface StudentService {

	public void save(Student student);

	public Student get(int id);
}
