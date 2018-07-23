package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  TouchInfo.java
 * Author:  vincent
 * Purpose: Defines the Class TouchInfo
 ***********************************************************************/

import java.util.*;

/**
 * 活动创建的信息，包括事件 创建人id 创建人name
 * 
 * @pdOid 69665dd4-aa69-48d9-bd63-5d585418761c
 */
public class TouchInfo {
	private int userId;
	private String name;
	private Date time;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}