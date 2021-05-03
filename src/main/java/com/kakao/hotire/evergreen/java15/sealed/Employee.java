package com.kakao.hotire.evergreen.java15.sealed;

import lombok.Getter;

// sealed, non-sealed or final modifiers expected
@Getter
public final class Employee extends Account {
    private String employee;
}
