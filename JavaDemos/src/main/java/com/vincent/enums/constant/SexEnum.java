package com.vincent.enums.constant;

import com.vincent.enums.EnumCommonInterface;

/**
 * 现在需要根据code的值获取枚举对象，简单直接的办法是在该枚举类中定义如下方法
 * 
 * 
 * @author WenSen
 * @date 2018年8月1日 下午6:07:33
 *
 */
public enum SexEnum implements EnumCommonInterface {
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

	@Override
	public Object getKey() {
		return code;
	}
}