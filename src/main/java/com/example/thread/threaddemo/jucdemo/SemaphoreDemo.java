package com.example.thread.threaddemo.jucdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * semaphore也就是我们常说的信号灯，semaphore可以控制同时访问的线程个数，通过acquire获取一个许可，如
 * 果没有就等待，通过release释放一个许可。有点类似限流的作用。叫信号灯的原因也和他的用处有关，比如某商
 * 场就5个停车位，每个停车位只能停一辆车，如果这个时候来了10辆车，必须要等前面有空的车位才能进入。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore =new Semaphore(5);     //允许5个信号量
        for (int i = 0; i < 10; i++) {  //同时开启10个线程
            new Car(i,semaphore).start();
        }
    }
    static class Car extends Thread{
        private int num;
        private Semaphore semaphore;
        public Car(int i,Semaphore semaphore){
            this.num=i;
            this.semaphore=semaphore;
        }
        public void run(){
            try{
                semaphore.acquire();//获取一个许可
                System.out.println("第"+num+"占用一个停车场");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第"+num+"辆车开走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
