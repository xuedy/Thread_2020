package com.example.thread.threaddemo.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * ，线程中还提供了静态方法Thread.interrupted()对设置中断标识的线程复位。比如在上面的案例中，外面的线程调用thread.interrupt来设置中断标识，而在线程里面，又通过Thread.interrupted把线程的标识又进行了复位
 */
public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
       Thread thread =new Thread(()->{
           while (true){
               boolean bl=Thread.currentThread().isInterrupted();
               if(bl){
                   System.out.println("before:"+bl);
                   Thread.interrupted();//对线程进行复位，中断标识为false
                   System.out.println("after:"+Thread.currentThread().isInterrupted());

               }

           }
       },"InterruptedDemo");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
