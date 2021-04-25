package com.kakao.hotire.evergreen.jvm.jol;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
class BooleanArrayTest {
    @Test
    void layout() {
        final boolean[] booleans = new boolean[3];
        log.info(ClassLayout.parseInstance(booleans).toPrintable());
    }
}
