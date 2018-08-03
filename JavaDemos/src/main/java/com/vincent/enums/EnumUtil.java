package com.vincent.enums;

import java.util.Map;

public class EnumUtil {
	/**
	 * 获取value返回枚举对象
	 * 
	 * @param value
	 * @param clazz
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EnumMessage> T getEnumObject(Object value, Class<T> clazz) {
		Map<Object, EnumMessage> map = Constant.ENUM_MAP.get(clazz);
		return (T) map.get(value);
	}
}
