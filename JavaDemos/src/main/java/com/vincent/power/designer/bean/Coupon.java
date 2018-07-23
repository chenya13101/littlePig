package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  Coupon.java
 * Author:  vincent
 * Purpose: Defines the Class Coupon
 ***********************************************************************/

/** @pdOid 2206ab7c-ec5b-4cec-ab80-71b9836102cd */
public class Coupon extends BaseBean {
	private int preferentialRange;
	private int effectiveDate;
	private int validityDate;
	private int overlay;
	private int usePlatform;
	private int couponDiscount;
	private int couponAmount;
	private int couponNum;
	private int modelTargetId;
	private int modelCode;
	private int fullElement;
	private TouchInfo touchInfo;
	private AuditInfo auditInfo;

	public int getPreferentialRange() {
		return preferentialRange;
	}

	public void setPreferentialRange(int preferentialRange) {
		this.preferentialRange = preferentialRange;
	}

	public int getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(int effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public int getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(int validityDate) {
		this.validityDate = validityDate;
	}

	public int getOverlay() {
		return overlay;
	}

	public void setOverlay(int overlay) {
		this.overlay = overlay;
	}

	public int getUsePlatform() {
		return usePlatform;
	}

	public void setUsePlatform(int usePlatform) {
		this.usePlatform = usePlatform;
	}

	public int getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(int couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public int getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}

	public int getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(int couponNum) {
		this.couponNum = couponNum;
	}

	public int getModelTargetId() {
		return modelTargetId;
	}

	public void setModelTargetId(int modelTargetId) {
		this.modelTargetId = modelTargetId;
	}

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}

	public int getFullElement() {
		return fullElement;
	}

	public void setFullElement(int fullElement) {
		this.fullElement = fullElement;
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