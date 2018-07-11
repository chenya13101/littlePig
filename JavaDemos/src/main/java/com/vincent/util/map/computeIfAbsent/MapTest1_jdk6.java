package com.vincent.util.map.computeIfAbsent;

//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

public class MapTest1_jdk6 {
	// static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
	// static {
	// cache.put(0, 0);
	// cache.put(1, 1);
	// }

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		// 普通方式
		System.out.println("Fibonacci(7) = " + fibonacci(7));

		long cost = System.currentTimeMillis() - begin;
		System.out.println(cost + "ms");
	}

	/**
	 * 普通的实现方式 普通方式使用大量的计算，存在性能问题. 并且计算量随着n的增加呈指数级增加，需要用到一些缓存策略，并且是线程安全的.
	 * 
	 * @param n
	 * @return
	 */
	static int fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;

		calculating();
		System.out.println("calculating Fibonacci(" + n + ")");
		return fibonacci(n - 2) + fibonacci(n - 1);
	}

	private static void calculating() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
