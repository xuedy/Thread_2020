package com.example.thread.threaddemo.interrupt;

import java.util.concurrent.TimeUnit;

public class ExceptionInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
            while (true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();// 抛出异常，将复位标志设置为false
                }
            }
        },"ExceptionInterruptDemo");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//复位标志设置为true
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.isInterrupted());//false
    }

}
