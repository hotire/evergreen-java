package com.kakao.hotire.evergreen.java11.bci;

import java.io.IOException;

public class BCI {

    /**
     * https://bytebuddy.net/#/
     */
    public static void main(String... args) throws IOException {
//    new ByteBuddy().redefine(Account.class)
//      .method(named("getName")).intercept(FixedValue.value("hotire"))
//      .make().saveIn(new File("/Users/kakao/Documents/myworkspace/java11/target/classes/"));
        System.out.println(new Account().getName());
    }

}
