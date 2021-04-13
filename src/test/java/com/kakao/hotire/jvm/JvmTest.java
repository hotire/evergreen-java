package com.kakao.hotire.jvm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.vm.VM;

@Slf4j
class JvmTest {

    @Test
    void currentDetail() {
        // no assert
        log.info(VM.current().details());
    }
}
