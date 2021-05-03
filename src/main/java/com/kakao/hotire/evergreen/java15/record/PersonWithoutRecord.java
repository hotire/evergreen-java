package com.kakao.hotire.evergreen.java15.record;

import lombok.Getter;

@Getter
public class PersonWithoutRecord {
    private final String name;
    private final Integer age;

    public PersonWithoutRecord(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

}
