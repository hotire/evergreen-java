package com.kakao.hotire.evergreen.exception;

public class FillInStackTrace extends RuntimeException {

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
