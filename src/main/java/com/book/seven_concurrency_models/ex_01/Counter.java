package com.book.seven_concurrency_models.ex_01;

import java.util.List;
import java.util.stream.IntStream;
import lombok.Getter;

/**
 * 읽기-수정-쓰기 패턴
 *  ++count to bytecode
 *  getfield #2
 *  icost_1
 *  iadd
 *  putfield #2
 *
 *  -> getfield count에 담김 값을 읽고 icost_1 거기에 1을 더하는 iadd putfield 결과를 다시 저장
 */
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
