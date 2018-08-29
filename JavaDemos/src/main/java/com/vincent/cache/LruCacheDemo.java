package com.vincent.cache;

public class LruCacheDemo {

	public static void main(String[] args) {
		LRUCache<String, String> cache = new LRUCache<>(3);
		// create map
		cache.put("1", "");
		cache.put("2", "");
		cache.put("3", "");

		// use map
		cache.get("1");// 改变了 linkedHashmap中entry的顺序,header由1指向了2.keySet顺序为<2,3,1>了
		cache.put("4", "");// remove掉了最老的2,加入了4，变为314
		cache.keySet().forEach(System.out::println);// 输出 314

	}
}
