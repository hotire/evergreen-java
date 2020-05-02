# Evergreen Java

### How To Install 

```shell script
brew tap AdoptOpenJDK/openjdk
brew cask install <version>
```
- https://github.com/AdoptOpenJDK/homebrew-openjdk
## java13 

- https://blog.codefx.org/java/java-13-guide/

## java11
study

## Time

### ZoneDateTime

LocalDateTime + Time-Zone 

### Instant

에포크 타임(EPOCH TIME, 1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초 단위로 표현한다

### OffSet

UTC로 부터 얼마만큼 떨어져 있는지 


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



## Compact String 

- vm option (default)
```
-XX:+UseCompressedStrings
```

- char[] 가 아닌 byte[]

```
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {

    @Stable
    private final byte[] value;
}
```

- How It Works

```
 private final byte coder;
```
: LATIN1 / UTF16을 구별하는 필드

```
public int indexOf(String str) {
        if (coder() == str.coder()) {
            return isLatin1() ? StringLatin1.indexOf(value, str.value)
                              : StringUTF16.indexOf(value, str.value);
        }
        if (coder() == LATIN1) {  // str.coder == UTF16
            return -1;
        }
        return StringUTF16.indexOfLatin1(value, str.value);
    }

```
: isLatin1() 체크를 통해 StringLantin1 / StringUTF16 으로 나누어 처리한다. 


- Performance Test 

: CompactPerformanceTest.class




