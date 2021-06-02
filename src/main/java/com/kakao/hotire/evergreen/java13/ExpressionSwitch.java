package com.kakao.hotire.evergreen.java13;

public class ExpressionSwitch {
    int classic(int input) {
        int result = 0;
        switch (input) {
            case 1:
            case 2:
                result = 1;
                break;
            case 3:
            case 4:
                result = 2;
                break;
            default:
                result = 3;
                break;
        }
        return result;
    }

    int getValueByClassic(int input) {
        return switch (input) {
            case 1, 2 -> 1;
            case 3, 4 -> 2;
            default -> 3;
        };
    }

    int getValue(int input) {
        final int result = switch (input) {
            case 1, 2:
                yield 1;
            case 3, 4:
                yield 2;
            default:
                yield 3;
        };
        return result;
    }
}
