package com.kakao.hotire.evergreen.java15.record;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void hashcode() {
        // expected
        assertThat(new Person("hotire", 30)).hasSameHashCodeAs(new Person("hotire", 30));
    }

    @Test
    void equals() {
        // expected
        assertThat(new Person("hotire", 30)).isEqualTo(new Person("hotire", 30));
    }

    @Test
    void testToString() {
        // no assert
        System.out.println(new Person("hotire", 30));
    }

    @Test
    void getter() {
        final Person person = new Person("hotire", 30);
        person.age();
        person.name();
        System.out.println(person.toString()); // Person[name=hotire, age=30]
        System.out.println(person.hashCode()); // 1099307279
    }

    @Test
    void field() {
        final Person person = new Person("hotire", 30);
        System.out.println(person);
    }
}