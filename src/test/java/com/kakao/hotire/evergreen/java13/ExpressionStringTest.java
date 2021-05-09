package com.kakao.hotire.evergreen.java13;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExpressionStringTest {

    @Test
    void json() throws JsonProcessingException {
        // given
        final ObjectMapper objectMapper = new ObjectMapper();
        final ExpressionString expressionString = new ExpressionString();

        // when
        final ExpressionString.User jdk8 = objectMapper.readValue(expressionString.getJdk8(), ExpressionString.User.class);
        final ExpressionString.User jdk13 = objectMapper.readValue(expressionString.getJdk13(), ExpressionString.User.class);

        // then
        assertThat(jdk8).isEqualTo(jdk13);
    }
}