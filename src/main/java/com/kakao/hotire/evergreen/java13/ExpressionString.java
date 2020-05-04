package com.kakao.hotire.evergreen.java13;

import lombok.Data;
import lombok.Getter;

@Getter
public class ExpressionString {
    private final String jdk8 = "{\"id\":1,\"name\":\"hotire\",\"age\":30}";
    private final String jdk13 = """
    {
        "id":1,
        "name":"hotire",
        "age":30
    }
    """;
    @Data
    public static class User {
        private Long id;
        private String name;
        private Integer age;
    }
}
