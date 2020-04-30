package com.kakao.hotire.evergreen.java11;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, properties = "server.port=8080")
public class Java11ControllerTest {

  private final String JAVA11_URL = "http://localhost:8080/hello";

  @Test
  public void openConnection() throws IOException {
    final URL url = new URL(JAVA11_URL);
    final URLConnection urlConnection = url.openConnection();
    try(Scanner scanner = new Scanner(urlConnection.getInputStream())){
      while (scanner.hasNextLine()) {
        assertEquals(scanner.nextLine(), "hello");
      }
    }
  }

  @Test
  public void restTemplate() {
    final RestTemplate restTemplate = new RestTemplateBuilder().build();
    final ResponseEntity<String> responseEntity = restTemplate.getForEntity(JAVA11_URL, String.class);
    assertEquals(responseEntity.getBody(), "hello");
  }

  @Test
  public void httpClient_block() throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(JAVA11_URL)).GET().build();
    final HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    assertEquals(httpResponse.body(), "hello");
  }

  @Test
  public void httpClient_async() throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(JAVA11_URL)).GET().build();
    CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(httpRequest, BodyHandlers.ofString());
    future.thenApply(HttpResponse::body)
      .thenAccept(log::info);

    log.info("async");
    Thread.sleep(1000); // shutdown
  }

  @Test
  public void webclient_async() throws InterruptedException {
    final WebClient webClient = WebClient.builder().build();
    webClient.get().uri(JAVA11_URL)
      .retrieve()
      .bodyToMono(String.class)
      .subscribe(log::info);

    log.info("async");
    Thread.sleep(1000); // shutdown
  }
}