package com.example.thread.threaddemo.processordemo;

import java.util.concurrent.LinkedBlockingDeque;

public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingDeque<Request> linkedBlockingDeque=new LinkedBlockingDeque<>();

//    private final RequestProcessor nextRequestProcessor;

//    public SaveProcessor(RequestProcessor nextRequestProcessor) {
//        this.nextRequestProcessor = nextRequestProcessor;
//    }

    public void run(){
        while (true){
            try {
                Request request=linkedBlockingDeque.take();
                System.out.println("save data"+request.getName());
//                nextRequestProcessor.ProcessRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void ProcessRequest(Request request) {
        linkedBlockingDeque.add(request);
    }
}
