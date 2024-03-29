package com.kakao.hotire.evergreen.java11;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CompactPerformanceTest {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();

        List<String> strings = IntStream.rangeClosed(1, 10_000_000)
                                        .mapToObj(Integer::toString)
                                        .collect(toList());

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(
                "Generated " + strings.size() + " strings in " + totalTime + " ms.");

        startTime = System.currentTimeMillis();

        String appended = strings.stream()
                                 .limit(100_000)
                                 .reduce("", (l, r) -> l + r);

        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Created string of length " + appended.length()
                           + " in " + totalTime + " ms.");
    }

}
