package com.vincent.enums;

import com.vincent.enums.constant.SexEnum;

public class Main {
	public static void main(String[] args) {
		SexEnum e1 = EnumUtil.getEnumObject("M", SexEnum.class);
		System.out.println(e1);// MAN
	}

}
