package com.example.thread.threaddemo.jucdemo;

import java.util.concurrent.CountDownLatch;

/**
 * JUC中提供了几个比较常用的并发工具类，比如CountDownLatch、CyclicBarrier、Semaphore。
 * CountDownLatch
 * countdownlatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完毕再执行。从
 * 命名可以解读到countdown是倒数的意思，类似于我们倒计时的概念。
 * countdownlatch提供了两个方法，一个是countDown，一个是await， countdownlatch初始化的时候需要传入一
 * 个整数，在这个整数倒数到0之前，调用了await方法的程序都必须要等待，然后通过countDown来倒数。
 */
/**使用场景
 * 1. 通过countdownlatch实现最大的并行请求，也就是可以让N个线程同时执行
 * 2. 比如应用程序启动之前，需要确保相应的服务已经启动，比如我们之前在讲zookeeper的时候，通过原生api连
 *  接的地方有用到countDownLatch
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(4); //CountDownLatch 是一个同步工具类，它允许一个线程一直等待，直到其他线程执行完毕再执行，计数器3
        new Thread(()->{
            countDownLatch.countDown(); //值递减 1
            System.out.println("T1: "+countDownLatch.getCount());
        },"T1").start();
        new Thread(()->{
            countDownLatch.countDown(); //值递减 1
            System.out.println("T2: "+countDownLatch.getCount());
        },"T2").start();
        new Thread(()->{
            countDownLatch.countDown(); //值递减 1 ,如果countDown没有变成0，后面就一直wait
            System.out.println("T3: "+countDownLatch.getCount());
        },"T3").start();
        countDownLatch.await();   //当countDown 的值倒数到0之前，调用了await()方法的程序 阻塞，然后通过 countDown来倒数
        System.out.println("所有线程执行完成");

    }
}
