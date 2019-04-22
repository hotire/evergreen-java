# java11
study

## String

### strip

- 공백 제거 메서드, 유니코드도 제거해준다.

### isBlank

- 공백 체크 메서드, 유니코드도 체크해준다.

### lines

- \n 라인 별로 잘라준다.

### repeat

- 문자열을 반복한다.

## HttpClient

자바11에 추가된 Client 라이브러리

### block
~~~
  @Test
  public void httpClient_block() throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(JAVA11_URL)).GET().build();
    final HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    assertEquals(httpResponse.body(), "hello");
  }
~~~
	
### async

~~~
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
~~~

: 그냥 WebClient 쓰자.

