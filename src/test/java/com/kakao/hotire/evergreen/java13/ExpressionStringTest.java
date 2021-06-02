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
        final TextBlocks textBlocks = new TextBlocks();

        // when
        final TextBlocks.User jdk8 = objectMapper.readValue(textBlocks.getClassic(), TextBlocks.User.class);
        final TextBlocks.User jdk13 = objectMapper.readValue(textBlocks.getTextBlocks(), TextBlocks.User.class);

        // then
        assertThat(jdk8).isEqualTo(jdk13);
    }
}