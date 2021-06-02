package com.kakao.hotire.evergreen.java15.record;

import java.util.Objects;

public class LegacyPerson {
    private final String name;
    private final Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LegacyPerson that = (LegacyPerson) o;
        return name.equals(that.name) && age.equals(that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public LegacyPerson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
