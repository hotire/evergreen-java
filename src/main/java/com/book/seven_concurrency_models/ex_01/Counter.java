package com.book.seven_concurrency_models.ex_01;

import java.util.List;
import java.util.stream.IntStream;
import lombok.Getter;

@Getter
public class Counter {
    private int count = 0;
    public void increment() {
        ++count;
    }
    public static void main(String ... args) throws InterruptedException {
        final Counter counter = new Counter();
        class CountingThead extends Thread {
            @Override
            public void run() {
                IntStream.range(0, 10000).forEach(i -> counter.increment());
            }
        }

        final List<CountingThead> countingTheadList = List.of(new CountingThead(), new CountingThead());

        countingTheadList.forEach(Thread::start);
        for (CountingThead countingThead : countingTheadList) {
            countingThead.join();
        }
        System.out.println(counter.getCount());
    }
}
