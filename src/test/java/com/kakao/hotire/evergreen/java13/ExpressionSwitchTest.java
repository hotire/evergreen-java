package com.kakao.hotire.evergreen.java13;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("ExpressionSwitch")
class ExpressionSwitchTest {

    @MethodSource("provideArguments")
    @ParameterizedTest
    void jdkClassic(final int input, final int expected) {
        // given
        final ExpressionSwitch expressionSwitch = new ExpressionSwitch();

        // when
        final int result = expressionSwitch.jdkClassic(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @MethodSource("provideArguments")
    @ParameterizedTest
    void jdk12(final int input, final int expected) {
        // given
        final ExpressionSwitch expressionSwitch = new ExpressionSwitch();

        // when
        final int result = expressionSwitch.jdk12(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @MethodSource("provideArguments")
    @ParameterizedTest
    void jdk13(final int input, final int expected) {
        // given
        final ExpressionSwitch expressionSwitch = new ExpressionSwitch();

        // when
        final int result = expressionSwitch.jdk13(input);

        // then
        assertThat(result).isEqualTo(expected);
    }


    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 2),
                Arguments.of(5, 3),
                Arguments.of(0, 3)
        );
    }
}