/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CyclicBarrierDemo
 * Author:   martin
 * Date:     2018/9/7 14:36
 * Description: 循环屏障
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名          修改时间          版本号            描述
 */
package com.vincent.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	private final static int THREAD_WAIT_NUM = 7;

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrierMaster = new CyclicBarrier(THREAD_WAIT_NUM, new Runnable() {
			@Override
			public void run() {
				System.out.println("七法师都到齐,出发集七龙珠......");
				callbackDragon();
			}
		});

		for (int i = 1; i <= THREAD_WAIT_NUM; i++) {
			int index = i;
			new Thread(() -> {
				try {
					System.out.println("法师" + index + "达到...");
					cyclicBarrierMaster.await();
					System.out.println("法师 " + index + "Await 后面事件...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

	private static void callbackDragon() {
		try {
			System.out.println("出发找龙珠中.....");
			Thread.yield();
			System.out.println("调用线程:" + Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CyclicBarrier cyclicBarrierDragonBall = new CyclicBarrier(THREAD_WAIT_NUM, new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("七龙珠都集齐,召唤神龙......");
					Thread.sleep(1000);
					System.out.println("召唤成功!b（￣▽￣）d　");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		for (int i = 1; i <= THREAD_WAIT_NUM; i++) {
			int index = i;
			new Thread(() -> {
				try {
					System.out.println("龙珠" + index + "找到");
					cyclicBarrierDragonBall.await();
					System.out.println("龙珠 " + index + " Await 后面事件...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

}
