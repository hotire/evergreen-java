package com.kakao.hotire.time;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Test;

public class InstantTest {

  @Test
  public void epoch() {
    final Instant epoch = Instant.EPOCH;
    assertThat(epoch.toString()).isEqualTo("1970-01-01T00:00:00Z");
  }

  @Test
  public void ofEpochSecond() {
    final Instant epoch = Instant.ofEpochSecond(0);
    assertThat(epoch.toString()).isEqualTo("1970-01-01T00:00:00Z");
  }

  @Test
  public void toZonedDateTime() {
    // Given
    final Instant now = Instant.now();

    // When
    ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Seoul"));

    // Then
    assertThat(zonedDateTime.toInstant()).isEqualTo(now);
  }

}
