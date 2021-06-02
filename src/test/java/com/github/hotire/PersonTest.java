package com.github.hotire;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void field() {
        final Person person = new Person("hotire", 30);
        System.out.println(person);
    }
}