package com.example.thread.threaddemo.threaddemo;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" MyCallable.call()");
        return "OK";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<String> future=executorService.submit(new MyCallable());
        System.out.println(future.get());
        executorService.shutdown();
    }
}
