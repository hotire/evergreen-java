package com.book.seven_concurrency_models.ex_01;

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
        Thread.yield(); // 현재 실행 중인 스레드가 사용중인 프로세서를 양보하여 다른 스레드에게 기회를 준다. 해당 줄이 없으면 항상 메인 스레드가 먼저 실행
        log.info("Hello from main thread");
        thread.join();
    }
}
