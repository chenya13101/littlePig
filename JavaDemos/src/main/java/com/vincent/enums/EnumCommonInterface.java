package com.vincent.enums;

public interface EnumCommonInterface {
	/**
	 * 让原有的枚举类实现这个接口，可以自由指定哪个属性作为主键。必要时还可以增加方法，制定枚举类中的其它属性作为主键
	 */
	Object getKey();
}
