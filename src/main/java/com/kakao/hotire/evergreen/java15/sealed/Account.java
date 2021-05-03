package com.kakao.hotire.evergreen.java15.sealed;

// sealed class must has subclasses
public abstract sealed class Account permits Employee, Manager {
}
