package com.vincent.io.analyse;

public class ReduceBean {

	private String method;

	private int count;

	private double average;

	private int max;

	private int min;

	public ReduceBean(String method, int count, double average, int max, int min) {
		super();
		this.method = method;
		this.count = count;
		this.average = average;
		this.max = max;
		this.min = min;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return new StringBuilder(String.format("%-70s", this.getMethod())).append("- 出现次数=").append(this.getCount())
				.append("- 最大值=").append(this.getMax()).append("- 最小值=").append(this.getMin()).append("- 平均数=")
				.append(this.getAverage()).toString();
	}
}
