package com.kakao.hotire.java11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Java11Controller {

  @GetMapping("/hello")
  public ResponseEntity hello() {
    return ResponseEntity.ok().body("hello");
  }
}
