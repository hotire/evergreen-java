package com.kakao.hotire.evergreen.java13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewStringMethodsTest {

    @Test
    void stripIndent() {
        final String html = "\t<html>\n" +
                "\t\t<body>\n" +
                "\t\t\t<p>Hello, world</p>\n" +
                "\t\t</body>\n" +
                "\t</html>";

        final String html2 = "<html>\n" +
                "\t<body>\n" +
                "\t\t<p>Hello, world</p>\n" +
                "\t</body>\n" +
                "</html>";

        assertThat(html).isNotEqualTo(html2);
        assertThat(html.stripIndent()).isEqualTo(html2);
    }

    @Test
    void formatted() {
        // given
        final String adjective = "multiline";

        // when
        final String phrase = """
        Hello
        %s
        text blocks!
        """.formatted(adjective);

        // then
        assertThat(phrase).contains(adjective);
    }

    @Test
    void translateEscapes() {
        // given
        final String tab = "\\t";

        // when
        final String result = tab.translateEscapes();

        // then
        assertThat(result).isEqualTo("\t");
    }
}
