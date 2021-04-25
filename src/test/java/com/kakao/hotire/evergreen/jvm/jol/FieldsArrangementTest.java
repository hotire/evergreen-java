package com.kakao.hotire.evergreen.jvm.jol;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
class FieldsArrangementTest {

    @Test
    void layout() {
        log.info(ClassLayout.parseClass(FieldsArrangement.class).toPrintable());
    }

}