package com.kakao.hotire.evergreen.java14;

/**
 * Standard
 * https://openjdk.java.net/jeps/361
 */
public class ExpressionSwitch {

    /**
     * statement vs expression
     *
     * https://shoark7.github.io/programming/knowledge/expression-vs-statement
     * https://gusdnd852.tistory.com/68
     */
//    public static void main(String... args) {
//        int a = 3; // statement
//        System.out.println(int b = 10); // error
//
//        a++; // statement && expression
//
//        a;    // expression
//        a +2; // expression
//    }

    enum Day {
        MONDAY, FRIDAY, SUNDAY, TUESDAY, THURSDAY, SATURDAY, WEDNESDAY
    }

    int getValue(final Day day) {
        switch (day) {
            case MONDAY:
                return 1;
            case FRIDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            default:
                return -1;
        }
    }

    void legacy(final Day day) {
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
        int numLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Wat: " + day);
        }
    }

    void jdk14(final Day day) {
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
        }
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }
}
