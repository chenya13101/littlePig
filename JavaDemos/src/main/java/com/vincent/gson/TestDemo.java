package com.vincent.gson;

import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestDemo {

	@Test
	public void test() {
		Point p1 = new Point(1, 3);
		Gson gson = new Gson();
		System.out.println(gson.toJson(p1));
		System.out.println("为y添加 transient关键字后不会再输出y信息");
	}

	@Test
	public void gson() {
		Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PROTECTED) // 第一种排除方式
				.create();
		// new GsonBuilder().excludeFieldsWithoutExposeAnnotation();// 第二种排除方式

		ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes fa) {
				return fa.getName().startsWith("_");
			}

			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}
		};
		Gson gson2 = new GsonBuilder().setExclusionStrategies(myExclusionStrategy).create();// 第3种排除方式

		Point obj = new Point(1, 2);
		String json = gson.toJson(obj); // <---
		Assert.assertEquals("{\"y\":2}", json);
		System.out.println(gson2.toJson(obj));
	}

}
