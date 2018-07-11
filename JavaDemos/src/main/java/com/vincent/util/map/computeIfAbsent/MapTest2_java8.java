package com.vincent.util.map.computeIfAbsent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTest2_java8 {

	public static void main(String[] args) throws InterruptedException {
		// 采用java7的同步线程方式及java8的本地缓存的方式
		// 构建多值Map样例代码
		Map<String, HashSet<String>> map1 = new HashMap<>();
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
		map1.computeIfAbsent("fruits2", k -> genValue(k)).add("banana");
		map1.computeIfAbsent("fruits2", k -> genValue(k)).add("water");
		System.out.println(map1);

		// 测试多线程并发处理，是否同步操作
		Map<String, String> map2 = new ConcurrentHashMap<>();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(() -> {
				map2.putIfAbsent("put absent", genValue2("abs"));
				// putIfAbsent 不管是否需要put(IfAbsent)都会调用genValue2
				map2.computeIfAbsent("name", k -> genValue2(k));
				map2.computeIfAbsent("addr", k -> genValue2(k));
				map2.computeIfAbsent("email", k -> genValue2(k));
				map2.computeIfAbsent("mobile", k -> genValue2(k));
			});
		}
		exec.shutdown();
		exec.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println(map2);
	}

	static HashSet<String> genValue(String str) {
		System.out.println("genValue");
		return new HashSet<String>();
	}

	static String genValue2(String str) {
		System.out.println(str + "===");
		return str + "2";
	}

}