package com.kakao.hotire.evergreen.java14;

/**
 * https://openjdk.java.net/jeps/358
 */

public class NPEHelper {

    public static void main(String... args) {
        new NPEHelper().npe();
    }

    public void npe() {
        methodA().methodB().methodC();
    }

    public NPEHelper methodA() {
        return this;
    }

    public NPEHelper methodB() {
        return null;
    }

    public NPEHelper methodC() {
        return this;
    }
}
