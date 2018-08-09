package com.vincent.thread.factory;

import java.lang.Thread.State;
import java.util.concurrent.ThreadFactory;

public class FactoryDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadFactory factory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				System.out.println("在这里是不是还可以用上缓存这些");
				previous();
				Thread t = new Thread(r);
				t.setName("东风" + System.currentTimeMillis());
				after();
				return t;
			}

			private void previous() {
				System.out.println("vc previous-创建线程");
			}

			private void after() {
				System.out.println("vc after-创建线程");
			}
		};

		Thread t1 = factory.newThread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run 一将功成万骨枯");
			}
		});

		t1.start();
		Thread.sleep(20);
		State state1 = t1.getState();
		System.out.println(state1.toString() + " 状态的线程无法start, 只有 " + State.NEW + " 状态的可以start");
		t1.start();
	}

}
