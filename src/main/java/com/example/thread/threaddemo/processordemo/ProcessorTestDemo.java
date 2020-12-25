package com.example.thread.threaddemo.processordemo;

public class ProcessorTestDemo {
    PrintProcessor printProcessor;
    protected ProcessorTestDemo(){

        SaveProcessor saveProcessor =new SaveProcessor();
        saveProcessor.start();
        printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public  void  doTest(Request request){
        printProcessor.ProcessRequest(request);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Request request=new Request(i+"");
            new ProcessorTestDemo().doTest(request);
        }
    }
}
