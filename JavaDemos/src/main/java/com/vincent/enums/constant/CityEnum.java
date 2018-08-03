package com.vincent.enums.constant;

import com.vincent.enums.EnumCommonInterface;

public enum CityEnum implements EnumCommonInterface {
	WAIT_COMMIT("深圳", 1),
	WAIT_AUDIT("广州", 2);

	private String name;
	private int index;

	private CityEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public Object getKey() {
		return name;
	}

}
