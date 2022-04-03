package com.kakao.hotire.evergreen.java11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class StringTest {

    /**
     * strip 은 유니코드 제거해준다.
     */
    @Test
    public void assert_strip() {
        final String name = " tire \u205F";

        final String trim = name.trim();
        log.debug(trim);
        assertNotEquals(trim, "tire");
        assertEquals(trim.length(), 6);

        final String strip = name.strip();
        log.debug(strip);
        assertEquals(strip, "tire");
        assertEquals(strip.length(), 4);
    }

    /**
     * isEmpty 는 길이가 0인 경우만 true
     * isBlank는 공백, 유니코드 체크
     */
    @Test
    public void assert_isBlank() {
        final String blank = " \u205F";
        assertTrue(blank.isBlank());
        assertFalse(blank.isEmpty());
    }

    /**
     * 문자열을 line 별로
     */
    @Test
    public void assert_lines() {
        final String lines = "tire.ho\nhello\nhi";
        final Queue<String> queue = new LinkedList<>();
        queue.add("tire.ho");
        queue.add("hello");
        queue.add("hi");

        lines.lines().forEach(line -> assertEquals(line, queue.poll()));
    }

    @Test
    public void assert_repeat() {
        final String name = "tire";
        assertEquals(name.repeat(3), "tiretiretire");
    }
}
