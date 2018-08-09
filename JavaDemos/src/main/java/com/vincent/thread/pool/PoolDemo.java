package com.vincent.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.vincent.thread.factory.DefaultThreadFactory;

public class PoolDemo {
	private static final int coreThreadSize = 2;
	private static final int maxThreadSize = 5;
	private static final int keepAliveTime = 2;

	private static final int bolckQueueSize = 5;

	public static void main(String[] args) {

		// 自定义拒绝执行处理器
		AtomicInteger atomic1 = new AtomicInteger();
		RejectedExecutionHandler rejectHandler = new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println(atomic1.incrementAndGet() + "--- " + r.hashCode()
						+ "------------- 被线程池拒绝了; activeCount = " + executor.getActiveCount());
				System.out.println("BlockingQueue 已有任务数" + executor.getQueue().size());
				// System.out.println(System.currentTimeMillis() + "已完成任务数" +
				// executor.getCompletedTaskCount());
			}
		};

		// RejectedExecutionHandler rejectHandler1 = new
		// ThreadPoolExecutor.AbortPolicy();//
		// 直接抛出java.util.concurrent.RejectedExecutionException

		// RejectedExecutionHandler rejectHandler2 = new
		// ThreadPoolExecutor.CallerRunsPolicy();
		// RejectedExecutionHandler rejectHandler3 = new
		// ThreadPoolExecutor.DiscardOldestPolicy();
		// RejectedExecutionHandler rejectHandler4 = new
		// ThreadPoolExecutor.DiscardPolicy();
		// 自定义线程池
		ThreadPoolExecutor pool = new ThreadPoolExecutor(coreThreadSize, maxThreadSize, keepAliveTime, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(bolckQueueSize), new DefaultThreadFactory(), rejectHandler);
		System.out.println("start = " + System.currentTimeMillis());
		AtomicInteger atomic = new AtomicInteger();
		for (int i = 0; i < 14; i++) {
			pool.execute(() -> {
				try {
					Thread.sleep(3000);
					System.out.println("计算完毕" + atomic.incrementAndGet());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		System.out
				.println("A 现有线程池数量: ActiveCount = " + pool.getActiveCount() + " getPoolSize = " + pool.getPoolSize());
		sleepSecond(11); // 查看线程池参数 keepAliveTime 是否生效了,如果生效，线程执行完两秒钟后getPoolSize()就会变化
		System.out.println("B 现有线程池数量: ActiveCount = " + pool.getActiveCount() + "-- 已完成" + pool.getCompletedTaskCount()
				+ " getPoolSize = " + pool.getPoolSize());// 线程池大小已改编为coreSize,时间与预期的一致

		pool.shutdown();
		try {
			pool.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void sleepSecond(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("*");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}
}
