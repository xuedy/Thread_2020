package com.example.thread.threaddemo.threadstatus;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
    public static void main(String[] args) {
        //TIME_WAITING
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"time_waiting").start();
        //WAITING 线程在ThreadStatus类锁上通过wait进行等待
        new Thread(()->{
            try {
                synchronized (ThreadStatusDemo.class){
                    ThreadStatusDemo.class.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"waiting").start();
        //线程在ThreadStatus加锁后，不会释放锁
        new Thread(new BlockedDemo(),"BlockedDemo-1").start();
        new Thread(new BlockedDemo(),"BlockedDemo-2").start();
    }

    static class BlockedDemo extends Thread{
           public void run(){
               synchronized (ThreadStatusDemo.class){
                   while (true){
                       try {
                           TimeUnit.SECONDS.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
    }
}
