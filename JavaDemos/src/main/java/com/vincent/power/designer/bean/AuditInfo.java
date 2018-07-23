package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  AuditInfo.java
 * Author:  vincent
 * Purpose: Defines the Class AuditInfo
 ***********************************************************************/

import java.util.*;

/** @pdOid 4fb0830b-d7d3-4a47-a49f-1fe15010a987 */
public class AuditInfo {
	/** @pdOid 84249fdf-11e5-4b50-9c0d-2bb07fb748bd */
	private Date auditTime;
	/** @pdOid 2050d329-fdc6-49f2-9eaa-439ff36f1000 */
	private int auditorId;
	/** @pdOid a3b5f382-f5f8-4105-a616-a934ab1823da */
	private String opinion;

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public int getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(int auditorId) {
		this.auditorId = auditorId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

}