package com.kakao.hotire.java11.bci;


import static org.assertj.core.api.Assertions.assertThat;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

public class BCITest {

  @Test
  public void bci() throws IllegalAccessException, InstantiationException {
    Class<?> dynamicType = new ByteBuddy()
      .subclass(Object.class)
      .method(ElementMatchers.named("toString"))
      .intercept(FixedValue.value("Hello World!"))
      .make()
      .load(getClass().getClassLoader())
      .getLoaded();

    assertThat(dynamicType.newInstance().toString()).isEqualTo("Hello World!");
  }
}