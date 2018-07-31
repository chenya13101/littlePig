package com.vincent.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class InvokeDemo {

	@Test
	public void test1() {
		Author author = new Author("12", "vip");
		show(author);
		invoke();
	}

	@Test
	public void invoke() {
		try {
			Class authorClass = Class.forName("com.vincent.invoke.Author"); // Author.class;
			Object obj = authorClass.newInstance();

			Method me1 = authorClass.getMethod("getName", null);

			Constructor[] cons = authorClass.getConstructors();
			for (Constructor constructor : cons) {
				Class[] cls = constructor.getParameterTypes();
				for (Class tmpC : cls) {
					System.out.println(constructor.getName() + "参数类型为:" + tmpC.getName());
				}

			}

			System.out.println(me1.invoke(obj, null));
			Method[] methods = authorClass.getDeclaredMethods();

			for (Method method : methods) {
				System.out.println(method.getName() + method.getParameterCount());
			}

			authorClass.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void show(Author author) {
		System.out.println(author.toString());
	}
}
