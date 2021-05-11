package com.kakao.hotire.evergreen.java16;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PatternMatchingForInstanceof {
    void legacy(final Object obj) {
        if (obj instanceof String) {
            String s = ((String) obj).toUpperCase();
            log.info(s);
        }
    }

    void jdk16(final Object obj) {
        if (obj instanceof String s) {
            log.info(s.toUpperCase());
        }
    }
}
