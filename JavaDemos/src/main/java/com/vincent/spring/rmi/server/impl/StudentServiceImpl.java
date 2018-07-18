package com.vincent.spring.rmi.server.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vincent.spring.rmi.common.bean.Student;
import com.vincent.spring.rmi.common.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private Map<Integer, Student> map = new HashMap<>();

	@Override
	public void save(Student student) {
		map.put(student.getId(), student);
	}

	@Override
	public Student get(int id) {
		return map.get(id);
	}

}
