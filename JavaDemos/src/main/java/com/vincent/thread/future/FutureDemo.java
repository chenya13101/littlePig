package com.vincent.thread.future;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {
	private Map<String, String> connectionPool = new ConcurrentHashMap<>();
	private Map<String, FutureTask<String>> connectionPool2 = new ConcurrentHashMap<>();

	/**
	 * 常规方法
	 * 
	 * @param key
	 * @return
	 */
	public String getConnection(String key) {
		if (connectionPool.containsKey(key)) {
			return connectionPool.get(key);
		} else {
			String conn = createConnection(key);
			connectionPool.put(key, conn);
			return conn;
		}
	}

	private String createConnection(String key) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return key + System.currentTimeMillis();
	}

	public String getConnectionByFuture(String key) throws InterruptedException, ExecutionException {
		FutureTask<String> task = connectionPool2.get(key);
		if (task != null) {
			return task.get();
		} else {
			Callable<String> callable = new Callable<String>() {
				@Override
				public String call() throws Exception {
					return null;
				}
			};
			FutureTask<String> newTask = new FutureTask<>(callable);
			FutureTask<String> oldTask = connectionPool2.putIfAbsent(key, newTask);
			if (oldTask == null) {
				oldTask = newTask;
				oldTask.run();
			}
			return oldTask.get();
		}
	}

	public static void main(String[] args) {
		FutureDemo demo = new FutureDemo();
		System.out.println(demo.getConnection("sszx"));

	}
}
