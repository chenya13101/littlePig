package com.vincent.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InvokeDemo2 {

	/**
	 * 调用指定的构造函数生成对象，而不是的 class.newInstance()无参构造函数
	 * 
	 * @param classType
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public <T> T test(Class<T> classType, Object... params) throws Exception {
		try {
			Constructor<T> constructor = classType.getConstructor(String.class, String.class);
			return constructor.newInstance(params);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw e;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) {
		InvokeDemo2 demo = new InvokeDemo2();
		try {
			Author author = demo.test(Author.class, "15", "abao");
			System.out.println(author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
