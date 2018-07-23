package com.vincent.power.designer.bean;
/***********************************************************************
 * Module:  BaseBean.java
 * Author:  vincent
 * Purpose: Defines the Class BaseBean
 ***********************************************************************/

/** @pdOid 17fecc59-40f7-4e2c-89d7-68bb227bbfdf */
public class BaseBean {
	/** @pdOid 637735d1-2d1f-4756-9c70-93e9b2d512a9 */
	private int id;
	/** @pdOid 69a8eb4d-bd49-45ce-8abd-6236c8b4085f */
	private int name;
	/** @pdOid d990f23d-5bad-45f1-8cd7-650ff8a574c2 */
	private int code;
	/** @pdOid b5bd879b-dff3-4775-981a-a156ad22c6c6 */
	private int deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}