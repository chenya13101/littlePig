package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  GiftActivity.java
 * Author:  vincent
 * Purpose: Defines the Class GiftActivity
 ***********************************************************************/

/** @pdOid 0220789e-5b31-45d5-936b-4b8f6bba543d */
public class GiftActivity extends ActivityAuditBean {
	private int priority;
	private int saleType;
	private int timeLimitStatus;
	private int timeLimitStart;
	private int timeLimitEnd;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getSaleType() {
		return saleType;
	}

	public void setSaleType(int saleType) {
		this.saleType = saleType;
	}

	public int getTimeLimitStatus() {
		return timeLimitStatus;
	}

	public void setTimeLimitStatus(int timeLimitStatus) {
		this.timeLimitStatus = timeLimitStatus;
	}

	public int getTimeLimitStart() {
		return timeLimitStart;
	}

	public void setTimeLimitStart(int timeLimitStart) {
		this.timeLimitStart = timeLimitStart;
	}

	public int getTimeLimitEnd() {
		return timeLimitEnd;
	}

	public void setTimeLimitEnd(int timeLimitEnd) {
		this.timeLimitEnd = timeLimitEnd;
	}

}