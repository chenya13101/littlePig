package com.vincent.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * 两个线程交替执行打印 1~100, 使用了synchronize和 notify wait
 * 
 * @author WenSen
 * @date 2018年7月23日 下午4:30:44
 *
 */
public class PrintSD {

	CountDownLatch latch = new CountDownLatch(1);

	private Object lock = new Object();

	// 定义打印的方法
	public void print(String str, boolean stop) {
		synchronized (lock) {
			lock.notify();
			System.out.println(str);
			try {
				if (!stop) {
					lock.wait();// 不加wait就完蛋,无法保证资源争用，本线程可能会继续获得执行机会Fs
				}

				// 加了wait，最后处于阻塞状态，主线程无法结束，需要加一个标记，判断是否wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 定义打印奇数的线程类
	class A implements Runnable {

		@Override
		public void run() {
			System.out.println("A " + System.currentTimeMillis());
			latch.countDown();
			for (int i = 1; i < 100; i += 2) {
				print("A" + i, false);
			}
		}
	}

	// 定义打印偶数的线程类
	class B implements Runnable {

		@Override
		public void run() {
			System.out.println("B " + System.currentTimeMillis());
			try {
				latch.await();
				System.out.println("latch 保证A线程一定会先执行" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 2; i <= 100; i += 2) {
				if (i == 100) {
					System.out.println("debug...+ i");
				}

				if (i == 100) {
					print("  B" + i, true);
				} else {
					print("  B" + i, false);
				}

			}
		}
	}

	public static void main(String[] args) {
		PrintSD p = new PrintSD();
		A a = p.new A();
		B b = p.new B();
		new Thread(b).start();
		try {
			Thread.sleep(200); // 故意增加难度，需要加countDownLactch才能保证A B执行顺序
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(a).start();

	}
}
