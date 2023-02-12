package com.book.seven_concurrency_models.ex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorld {

    public static void main(String ... args) throws InterruptedException {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("Hello from new thread");
            }
        };

        thread.start();
        Thread.yield();
        log.info("Hello from main thread");
        thread.join();
    }
}
