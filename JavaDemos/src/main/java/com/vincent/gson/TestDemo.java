package com.vincent.gson;

import org.junit.Test;

import com.google.gson.Gson;

public class TestDemo {

	@Test
	public void test() {
		Point p1 = new Point(1, 3);
		Gson gson = new Gson();
		System.out.println(gson.toJson(p1));
	}
}
