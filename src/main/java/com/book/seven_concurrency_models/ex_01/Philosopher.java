package com.book.seven_concurrency_models.ex_01;

import java.util.Random;

/**
 * 데드락 코드
 * 식사하는 철학자
 */
public class Philosopher extends Thread {
    private final Object left;
    private final Object right;
    private final Random random = new Random();

    public Philosopher(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));           //  1. 생각
                synchronized (left) {                               //  2. 왼쪽 젓가락
                    synchronized (right) {                          //  3. 오른쪽 젓가락
                        Thread.sleep(random.nextInt(1000));  //  4. 먹는다
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
