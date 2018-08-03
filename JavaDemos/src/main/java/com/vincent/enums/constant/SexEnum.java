package com.vincent.enums.constant;

import com.vincent.enums.EnumMessage;

/**
 * 现在需要根据code的值获取枚举对象，简单直接的办法是在该枚举类中定义如下方法
 * 
 * 
 * @author WenSen
 * @date 2018年8月1日 下午6:07:33
 *
 */
public enum SexEnum implements EnumMessage {
	MAN("M", "男"),
	WOMAN("F", "女");

	private String code;
	private String desc;

	SexEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static SexEnum getSexEnumByCode(String code) {
		System.out.println(
				"现在需要根据code的值获取枚举对象，简单直接的办法是在该枚举类中定义如下方法：" + "以这种方案实现时，需要在每个枚举类中都定义类似上述结构的方法。当项目中的枚举类较多时，显得代码冗余。");
		for (SexEnum sexEnum : SexEnum.values()) {
			if (sexEnum.getCode().equals(code)) {
				return sexEnum;
			}
		}
		return null;
	}

	@Override
	public Object getValue() {
		return code;
	}
}