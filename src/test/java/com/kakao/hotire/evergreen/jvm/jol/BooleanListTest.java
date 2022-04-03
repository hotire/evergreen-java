package com.kakao.hotire.evergreen.jvm.jol;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.List;

@Slf4j
class BooleanListTest {
    @Test
    void layout() {
        final List<Boolean> booleans = List.of(false, false, false);
        log.info(ClassLayout.parseInstance(booleans).toPrintable());
    }
}
