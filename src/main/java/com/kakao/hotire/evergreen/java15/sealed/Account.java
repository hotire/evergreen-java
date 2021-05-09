package com.kakao.hotire.evergreen.java15.sealed;

// preview
// sealed class must has subclasses
public abstract sealed class Account permits Employee, Manager {
}
