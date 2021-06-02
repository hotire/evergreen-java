package com.kakao.hotire.evergreen.java13;

import lombok.Data;
import lombok.Getter;

@Getter
public class TextBlocks {
    private final String classic = ""
                                   + "{\n "
                                   + "     \"id\":1,\n"
                                   + "     \"name\":\"hotire\",\n"
                                   + "     \"age\":30\n"
                                   + "}\n";

    private final String textBlocks = """
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
