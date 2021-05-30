package com.kakao.hotire.evergreen.java15.sealed;

import lombok.Getter;

@Getter
public non-sealed class Manager extends Account {
    private String name;
    private final Manager manager = new Manager() {};
}
