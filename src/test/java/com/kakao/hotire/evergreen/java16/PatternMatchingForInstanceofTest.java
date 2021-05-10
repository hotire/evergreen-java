package com.kakao.hotire.evergreen.java16;

import org.junit.jupiter.api.Test;

class PatternMatchingForInstanceofTest {

    @Test
    void jdk16() {
        // given
        final PatternMatchingForInstanceof matching = new PatternMatchingForInstanceof();

        // when
        matching.jdk16("HELLO");
    }
}