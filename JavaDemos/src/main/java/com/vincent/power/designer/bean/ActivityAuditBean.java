package com.vincent.power.designer.bean;

/***********************************************************************
 * Module:  ActivityAuditBean.java
 * Author:  vincent
 * Purpose: Defines the Class ActivityAuditBean
 ***********************************************************************/

import java.util.*;

/**
 * 活动基础类，含有活动的基本属性
 * 
 * @pdOid 9ed75e8c-68df-41f0-9f00-773aaad6fddf
 */
public class ActivityAuditBean extends BaseBean {
	private Date startTime;
	private Date endTime;
	private int status;
	private Date releaseTime;
	private String enterpriseCode;
	private int auditorRelease;
	private int overlay;
	private int prefRange;
	private TouchInfo touchInfo;
	private AuditInfo auditInfo;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getEnterpriseCode() {
		return enterpriseCode;
	}

	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}

	public int getAuditorRelease() {
		return auditorRelease;
	}

	public void setAuditorRelease(int auditorRelease) {
		this.auditorRelease = auditorRelease;
	}

	public int getOverlay() {
		return overlay;
	}

	public void setOverlay(int overlay) {
		this.overlay = overlay;
	}

	public int getPrefRange() {
		return prefRange;
	}

	public void setPrefRange(int prefRange) {
		this.prefRange = prefRange;
	}

	public TouchInfo getTouchInfo() {
		return touchInfo;
	}

	public void setTouchInfo(TouchInfo touchInfo) {
		this.touchInfo = touchInfo;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}

}