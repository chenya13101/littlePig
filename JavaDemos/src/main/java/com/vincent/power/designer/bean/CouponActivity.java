package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  CouponActivity.java
 * Author:  vincent
 * Purpose: Defines the Class CouponActivity
 ***********************************************************************/

/**
 * 优惠券活动
 * 
 * @pdOid 5ec3e674-bfd0-41c7-b114-86623912120a
 */
public class CouponActivity extends ActivityAuditBean {
	private String enterpriseId;
	private int receiveFrequencyType;
	private int receiveFrequency;
	private int grantMode;

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public int getReceiveFrequencyType() {
		return receiveFrequencyType;
	}

	public void setReceiveFrequencyType(int receiveFrequencyType) {
		this.receiveFrequencyType = receiveFrequencyType;
	}

	public int getReceiveFrequency() {
		return receiveFrequency;
	}

	public void setReceiveFrequency(int receiveFrequency) {
		this.receiveFrequency = receiveFrequency;
	}

	public int getGrantMode() {
		return grantMode;
	}

	public void setGrantMode(int grantMode) {
		this.grantMode = grantMode;
	}

}