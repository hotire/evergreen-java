package com.kakao.hotire.evergreen.jvm.jol;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
class IntWrapperTest {

    /**
     *  vm option
     *  -XX:-UseCompressedOops
     */
    @Test
    void layout() {
        log.info(ClassLayout.parseClass(IntWrapper.class).toPrintable());
    }

    @Test
    void layoutInstance() {
        log.info(ClassLayout.parseInstance(new IntWrapper()).toPrintable());
    }

    @Test
    void layoutInstanceWithHashCode() {
        final IntWrapper intWrapper = new IntWrapper();
        intWrapper.hashCode();
        log.info(ClassLayout.parseInstance(intWrapper).toPrintable());
    }
}