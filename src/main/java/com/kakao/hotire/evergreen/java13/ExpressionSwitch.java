package com.kakao.hotire.evergreen.java13;

public class ExpressionSwitch {
    int jdkClassic(int input) {
        int result = 0;
        switch(input){
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            default:
                result = 3;
                break;
        }
        return result;
    }

    int jdk12(int input) {
        return switch (input) {
            case 1, 2 -> 1;
            case 3, 4 -> 2;
            default -> 3;
        };
    }

    int jdk13(int input) {
        return switch (input) {
            case 1, 2:
                yield 1;
            case 3, 4:
                yield 2;
            default:
                yield 3;
        };
    }
}
