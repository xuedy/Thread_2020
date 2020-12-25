package com.example.thread.threaddemo.threaddemo;

public class MyThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+" My Thread.run()");
    }
    public static void main(String[] args) {
        MyThread myThread1=new MyThread();
        myThread1.setName("1");
        MyThread myThread2=new MyThread();
        myThread2.setName("2");
        myThread1.start();
        myThread2.start();
    }
}
