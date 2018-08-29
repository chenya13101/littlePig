package com.vincent.cache.google.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * https://www.cnblogs.com/always-online/p/4062856.html#undefined
 * 
 * 缓存对象指定长度时间,设置更新读写策略
 * 
 * @author WenSen
 * @date 2018年7月11日 上午10:53:07
 *
 */
public class TestGuavaCache_CacheLoader {

	@Test
	public void testUserCacheLoader() throws ExecutionException {
		// 模拟数据
		final List<Person> dbList = new ArrayList<Person>(5);
		dbList.add(new Person("1", "zhangsan"));
		dbList.add(new Person("2", "lisi"));
		dbList.add(new Person("3", "wangwu"));

		// 创建cache
		LoadingCache<String, Person> cache = CacheBuilder.newBuilder()//
				.refreshAfterWrite(3, TimeUnit.SECONDS)// 给定时间内没有被读/写访问，则回收。
				// .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
				// .expireAfterAccess(3, TimeUnit.SECONDS)// 缓存过期时间为3秒
				.maximumSize(100).// 设置缓存个数
				build(new CacheLoader<String, Person>() {
					@Override
					/**
					 * 当本地缓存命没有中时，调用load方法获取结果并将结果缓存
					 */
					public Person load(String key) throws ExecutionException {
						System.out.println(key + " load in cache");
						return getPerson(key);
					}

					// 此时一般我们会进行相关处理，如到数据库去查询
					private Person getPerson(String key) throws ExecutionException {
						System.out.println(key + " query");
						for (Person p : dbList) {
							if (p.getId().equals(key))
								return p;
						}
						return null;
					}
				});

		searchCache(cache);
		System.out.println("======= sencond time  ==========");
		searchCache(cache);
		System.out.println("======= third time after 3 sencond ==========");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchCache(cache);
	}

	private void searchCache(LoadingCache<String, Person> cache) throws ExecutionException {
		cache.get("1");
		cache.get("2");
		cache.get("3");
	}
}