package com.kakao.hotire.evergreen.jvm.jol;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
class LockTest {

    @Test
    void layoutWithLock() {
        final Lock lock = new Lock();
        log.info(ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock) {
            log.info(ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}