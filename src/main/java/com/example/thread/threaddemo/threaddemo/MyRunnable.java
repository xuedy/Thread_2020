package com.example.thread.threaddemo.threaddemo;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" MyRunnable.run()");
    }

    public static void main(String[] args) {
        Thread myRunnable= new Thread(new MyRunnable(),"1");
        myRunnable.start();
    }
}
