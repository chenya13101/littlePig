package com.vincent.util.map.computeIfAbsent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest2_jdk6 {
	static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
	static {
		cache.put(0, 0);
		cache.put(1, 1);
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		// 普通方式
		System.out.println("FibonacciJava7(7) = " + fibonacciJava7(7));

		long cost = System.currentTimeMillis() - begin;
		System.out.println(cost + "ms");
	}

	/**
	 * 在java7中的实现方式 在java7中，通过synchronized进行线程同步，检查缓存是否存在key对应的值，如果不存在才进行计算并放入缓存中
	 * 为了更好的性能，需要使用 double-checked locking，那样代码会更复杂
	 * 
	 * @param n
	 * @return
	 */
	static int fibonacciJava7(int n) {
		if (n == 0 || n == 1)
			return n;

		calculating();
		Integer result = cache.get(n);

		if (result == null) {
			synchronized (cache) {
				result = cache.get(n);

				if (result == null) {
					System.out.println("calculating FibonacciJava7(" + n + ")");
					result = fibonacciJava7(n - 2) + fibonacciJava7(n - 1);
					cache.put(n, result);
				}
			}
		}
		return result;
	}

	private static void calculating() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
