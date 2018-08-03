package com.vincent.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.vincent.enums.constant.SexEnum;

public class EnumUtil2 {

	private static Map<Class<?>, Object> enumMap = new ConcurrentHashMap<>();

	/**
	 * 改进后的方法，不需要初始化一大堆的map.
	 */
	public static <T extends EnumCommonInterface> T getEnumObject(Object key, Class<T> clazz) {
		if (!clazz.isEnum()) {
			throw new IllegalArgumentException("非枚举类型");
		}

		Object mapValue = enumMap.get(clazz);
		if (mapValue == null) {
			try {
				enumMap.put(clazz, clazz.getEnumConstants());
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

	public static void main(String[] args) {
		SexEnum enum1 = EnumUtil2.getEnumObject("M", SexEnum.class);
		System.out.println(enum1);
	}
}
