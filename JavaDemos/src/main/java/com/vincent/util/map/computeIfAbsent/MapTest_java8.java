package com.vincent.util.map.computeIfAbsent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest_java8 {
	static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
	static {
		cache.put(0, 0);
		cache.put(1, 1);
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		// 普通方式
		System.out.println("FibonacciJava8(7) = " + fibonacciJava8(7));

		long cost = System.currentTimeMillis() - begin;
		System.out.println(cost + "ms");
	}

	/**
	 * 采用java8的本地缓存方式 如果缓存MAP中不存在指定key的值，会自动调用mappingFunction(key)计算key的value 然后将key
	 * = value放入到缓存Map,java8会使用thread-safe的方式从cache中存取记录
	 * 
	 * @param n
	 * @return
	 */
	static int fibonacciJava8(int n) {
		
		return cache.computeIfAbsent(n, (key) -> {
			calculating();
			System.out.println("calculating FibonacciJava8 " + n);
			return fibonacciJava8(n - 2) + fibonacciJava8(n - 1);
		});
	}

	private static void calculating() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
