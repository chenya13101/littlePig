package com.vincent.thread.demo;

/**
 * 
 * wait后失去锁不会尝试再次获取，wait(100)失去锁后会尝试再次获取锁。
 * 
 * @author WenSen
 * @date 2018年7月24日 上午9:16:52
 *
 */
public class WaitDemo {

	public static void main(String[] args) {

		Object lock = new Object();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						if (i == 5) {
							try {
								lock.wait(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("A" + i);
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t.start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						try {
							if (i == 8) {
								lock.wait(70);
							}
							System.out.println("  B" + i);
							Thread.sleep(50);
							// lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}

}
