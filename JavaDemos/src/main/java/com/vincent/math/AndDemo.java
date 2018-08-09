package com.vincent.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AndDemo {

	@Test
	public void testAnd() {
		System.out.println("按位与原理：新生成的数值 <= 两者中的最大值,而且稳定，快速");
		int i = 5; // 0101
		int j = 12; // 1100
		int d = i & j;
		assertEquals(d, 4);
	}

}
