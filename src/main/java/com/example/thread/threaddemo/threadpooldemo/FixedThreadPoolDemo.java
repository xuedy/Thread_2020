package com.example.thread.threaddemo.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 * JDK 为我们内置了几种常见线程池的实现，均可以使用 Executors 工厂类创建
 * 为了更好的控制多线程，JDK提供了一套线程框架Executor，帮助开发人员有效的进行线程控制。它们都在
 * java.util.concurrent包中，是JDK并发包的核心。
 * 其中有一个比较重要的类:Executors，他扮演着线程工厂的角色，我们通过Executors可以创建特定功能的线程池
 * newFixedThreadPool**：**该方法返回一个固定数量的线程池，线程数不变，当有一个任务提交时，若线程池
 * 中空闲，则立即执行，若没有，则会被暂缓在一个任务队列中，等待有空闲的线程去执行。
 * newSingleThreadExecutor: 创建一个线程的线程池，若空闲则执行，若没有空闲线程则暂缓在任务队列中。
 * newCachedThreadPool**：**返回一个可根据实际情况调整线程个数的线程池，不限制最大线程数量，若用空
 * 闲的线程则执行任务，若无任务则不创建线程。并且每一个空闲线程会在60秒后自动回收
 * newScheduledThreadPool: 创建一个可以指定线程的数量的线程池，但是这个线程池还带有延迟和周期性执行
 * 任务的功能，类似定时器。
 */
public class FixedThreadPoolDemo implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
    static ExecutorService executorService= Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new FixedThreadPoolDemo());
        }
        executorService.shutdown();
    }
}
/**
 * submit和execute的区别
 * 执行一个任务，可以使用submit和execute，这两者有什么区别呢？
 * \1. execute只能接受Runnable类型的任务
 * \2. submit不管是Runnable还是Callable类型的任务都可以接受，但是Runnable返回值均为void，所以使用
 * Future的get()获得的还是null
 */
