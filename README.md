# Evergreen Java

### Memory Layout of Objects in Java
- https://blog.naver.com/gngh0101/222322390483
- https://www.baeldung.com/java-memory-layout

### Compressed OOPs in the JVM

https://www.baeldung.com/jvm-compressed-oops

### How To Install 

```shell script
brew tap AdoptOpenJDK/openjdk
brew cask install <version>
```
- https://github.com/AdoptOpenJDK/homebrew-openjdk

## java15


### ZGC
https://www.baeldung.com/jvm-zgc-garbage-collector

- https://openjdk.java.net/projects/jdk/15/
- https://www.baeldung.com/java-15-new
- http://cr.openjdk.java.net/~pliden/slides/ZGC-FOSDEM-2018.pdf


## java13 
study 

### Switch Expression

- https://blog.naver.com/gngh0101/221945983737


### Reference
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

## baeldung-java-tutorial

https://www.baeldung.com/java-tutorial

### Native

https://www.baeldung.com/java-native

### Beyond Java

https://blog.naver.com/gngh0101/222396980468


## ZGC

- https://d2.naver.com/helloworld/0128759

ZGC(Z Garbage Collector)는 Serial GC와 Parallel Old GC, Parallel GC, CMS GC, G1 GC를 지나 새로운 세대로 등장한 Java의 garbage collector이다. 
ZGC는 JDK 11에 실험적 기능으로 추가되었고, JDK 15에서 정식으로 garbage collector로 인정된 다음 LTS(long term support) 버전인 JDK 17에도 반영되었다.


### ZPage

이전 세대의 garbage collector인 G1 GC에서는 메모리를 region이라는 논리적인 단위로 구분한다. 
새로운 세대의 garbage collector인 ZGC에서는 메모리를 ZPage라는 논리적인 단위로 구분한다.


## switch - if-else jump table

- https://www.geeksforgeeks.org/switch-vs-else/
- https://www.baeldung.com/cs/if-else-switch
