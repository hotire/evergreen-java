package com.kakao.hotire.java11.bci;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class BCI {

  /**
   * https://bytebuddy.net/#/
   */
  public static void main(String ... args) throws IOException {
//    new ByteBuddy().redefine(Account.class)
//      .method(named("getName")).intercept(FixedValue.value("hotire"))
//      .make().saveIn(new File("/Users/kakao/Documents/myworkspace/java11/target/classes/"));
    System.out.println(new Account().getName());
  }

}
