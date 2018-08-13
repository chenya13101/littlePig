package com.vincent.io.analyse;

import java.io.Serializable;

public class Record implements Serializable {

	private static final long serialVersionUID = 5063068880716663513L;

	private String logTime;

	private int costTime;

	private String method;

	public Record(String logTime, int costTime, String method) {
		super();
		this.logTime = logTime;
		this.costTime = costTime;
		this.method = method;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public int getCostTime() {
		return costTime;
	}

	public void setCostTime(int costTime) {
		this.costTime = costTime;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return this.costTime + ", logTime=" + this.logTime;
	}
}
