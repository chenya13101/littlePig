package com.vincent.io.analyse;

import java.io.Serializable;

public class ReduceBean implements Serializable {
	private static final long serialVersionUID = 2283702380920651944L;

	private String method;

	private long count;

	private double average;

	private Record max;

	private Record min;

	public ReduceBean(String method, long count, double average, Record max, Record min) {
		super();
		this.method = method;
		this.count = count;
		this.average = average;
		this.max = max;
		this.min = min;
	}

	public void setMax(Record max) {
		this.max = max;
	}

	public void setMin(Record min) {
		this.min = min;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public Record getMax() {
		return max;
	}

	public Record getMin() {
		return min;
	}

	@Override
	public String toString() {
		StringBuilder builder;
		if (this.method.length() > 70)
			builder = new StringBuilder(method.subSequence(0, 67)).append("...");
		else {
			builder = new StringBuilder(String.format("%-70s", this.getMethod()));
		}

		return builder.append(" -出现次数=").append(String.format("%-4s", this.getCount())).append(" -平均数=")
				.append(String.format("%-4s", new Double(this.getAverage()).intValue())).append(" -最小值=")
				.append(String.format("%-4s", this.getMin().getCostTime())).append("-最大值=")
				.append(String.format("%-4s", this.getMax())).toString();
	}
}
