package com.vincent.stack;

public class StackOverflowDemo {

	public static void main(String[] args) {
		System.out.println("设置 -Xss1K");
		new Thread(new Runnable() {
			@Override
			public void run() {
				loop(0);

			}

			private void loop(int i) {
				if (i < 1000) {
					loop(i++);
				}
			}
		}).start();
	}

}
