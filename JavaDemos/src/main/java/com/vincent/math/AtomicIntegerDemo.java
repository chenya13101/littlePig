package com.vincent.math;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger(4);
		// compareAndSet 被用于incrementAndGet这样的原子操作内。如果返回false，会重试调用compareAndSet
		System.out.println(i + " " + i.compareAndSet(i.incrementAndGet(), 5));
		while (!i.compareAndSet(i.incrementAndGet(), 5)) {// 只有在其它线程改变了这个值的情况下，才会进入
			System.out.println(i.get());
		}
		System.out.println(i + " " + i.compareAndSet(i.incrementAndGet(), 5));
	}
}
