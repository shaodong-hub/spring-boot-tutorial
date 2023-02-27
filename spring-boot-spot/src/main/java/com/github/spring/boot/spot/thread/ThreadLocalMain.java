package com.github.spring.boot.spot.thread;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

/**
 * create in 2023/2/9 14:18
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class ThreadLocalMain {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    private static final CountDownLatch LATCH = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        extracted("Main");
        new Thread(() -> extracted("Thread1")).start();
        new Thread(() -> extracted("Thread2")).start();
        LATCH.await();
        System.out.println(THREAD_LOCAL.get());
    }

    private static void extracted(String name) {
        THREAD_LOCAL.set(name);
        LATCH.countDown();
        System.out.println(name + " " + THREAD_LOCAL.get());
    }

    private static void soft(){
        SoftReference<String> softReference = new SoftReference<>("123");
        WeakReference<String> weakReference = new WeakReference<>("345");
    }

}
