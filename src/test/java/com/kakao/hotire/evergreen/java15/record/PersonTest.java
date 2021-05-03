package com.kakao.hotire.evergreen.java15.record;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void hashcode() {
        // given
        var person = new Person("hotire", 30);

        // when
        var result = person.hashCode();

        // then
        assertThat(result).isEqualTo(new Person("hotire", 30).hashCode());
    }

    @Test
    void equals() {
        // expected
        assertThat(new Person("hotire", 30)).isEqualTo(new Person("hotire", 30));
    }


}