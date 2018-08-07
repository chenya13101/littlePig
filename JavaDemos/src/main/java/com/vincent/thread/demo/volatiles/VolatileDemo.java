package com.vincent.thread.demo.volatiles;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileDemo {

	private static volatile int vol = 0;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("volatile控制了线程中对象的可见性,但并不能保证在此对象上操作的原子性. 比如不是每一次的结果都是 100.出现不一致的概率10%以上");
		System.out.println("曾经输出过：92 ");
		ExecutorService exe = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {
			Runnable command = new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						vol++;
						if (vol % 10 == 0)
							System.out.println(vol);
					}
				}
			};
			exe.execute(command);
		}

		exe.shutdown();
		exe.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println(vol);

	}

}
