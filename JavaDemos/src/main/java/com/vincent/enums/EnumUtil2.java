package com.vincent.enums;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.vincent.enums.constant.SexEnum;

public class EnumUtil2 {

	private static Map<Class<?>, Object> enumMap = new ConcurrentHashMap<>();

	/**
	 * 改进后的方法，不需要初始化一大堆的map
	 * 
	 * @param value
	 * @param clazz
	 * @return
	 */
	public static <T extends EnumCommonInterface> T getEnumObject2(Object key, Class<T> clazz) {
		Object mapValue = enumMap.get(clazz);
		if (mapValue == null) {
			try {
				putEnumsIntoMap(clazz);
				mapValue = enumMap.get(clazz);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		@SuppressWarnings("unchecked")
		T[] enumArray = (T[]) mapValue;
		Optional<T> optional = Arrays.stream(enumArray).filter(enumKey -> key.equals(enumKey.getKey())).findAny();
		return optional.isPresent() ? optional.get() : null;
	}

	private static <T extends EnumCommonInterface> void putEnumsIntoMap(Class<T> clazz) throws Exception {
		Method method = clazz.getMethod("values");
		Object obj = method.invoke(clazz);

		@SuppressWarnings("unchecked")
		T[] enumArray = (T[]) obj;
		enumMap.put(clazz, enumArray);
	}

	public static void main(String[] args) {
		SexEnum enum1 = EnumUtil2.getEnumObject2("M", SexEnum.class);
		System.out.println(enum1);
	}
}
