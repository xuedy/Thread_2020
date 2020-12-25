package com.example.thread.threaddemo.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源，而不是武断地将线程停止，因此这种终止线程的做法显得更加安全和优雅
 */
public class InterruptDemo {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Num:"+i);
        },"interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
