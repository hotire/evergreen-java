package com.kakao.hotire.evergreen.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class FillInStackTraceTest {

    @Test
    void fillInStackTrace() {
        try {
            throw new FillInStackTrace();
        } catch (final FillInStackTrace e) {
            assertThat(e.getStackTrace()).isEmpty();
            log.error(e.getMessage(), e);
        }

        try {
            throw new RuntimeException();
        } catch (final RuntimeException e) {
            assertThat(e.getStackTrace()).isNotEmpty();
            log.error(e.getMessage(), e);
        }
    }
}