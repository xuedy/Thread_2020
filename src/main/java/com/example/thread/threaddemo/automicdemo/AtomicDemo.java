package com.example.thread.threaddemo.automicdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当在多线程情况下，同时更新一个共享变量，由于我们前面讲过的原子性问题，可能得不到预期的结果。如果要达
 * 到期望的结果，可以通过synchronized来加锁解决，因为synchronized会保证多线程对共享变量的访问进行排
 * 队。
 * 在Java5以后，提供了原子操作类，这些原子操作类提供了一种简单、高效以及线程安全的更新操作。而由于变量
 * 的类型很多，所以Atomic一共提供了12个类分别对应四种类型的原子更新操作，基本类型、数组类型、引用类
 * 型、属性类型
 * 基本类型对应：AtomicBoolean、AtomicInteger、AtomicLong
 * 数组类型对应：AtomicIntegerArray、AtomicLongArray、AtomicReferenceArray
 * 引用类型对应：AtomicReference、AtomicReferenceFieldUpdater、AtomicMarkableReference
 * 字段类型对应：AtomicIntegerFieldUpdater、AtomicLongFieldUpdater、AtomicStampedReference
 */
public class AtomicDemo {
    private static AtomicInteger count=new AtomicInteger(0);
    //不加synchronized 也可以
    public static synchronized  void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            new Thread(()->{
                AtomicDemo.inc();
            }).start();
        }
        Thread.sleep(4000);
        System.out.println(count.get());
    }
}
