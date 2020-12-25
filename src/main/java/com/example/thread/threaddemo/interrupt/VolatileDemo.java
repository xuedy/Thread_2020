package com.example.thread.threaddemo.interrupt;

public class VolatileDemo {
     private volatile  static boolean stop=false;

    public static void main(String[] args) {
        Thread thread =new Thread(()->{
            int i=0;
            while (!stop){
                i++;
            }
        },"VolatileDemo ");
        thread.start();
        System.out.println("begin start");
        stop=true;
    }

}
