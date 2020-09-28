# StringTokenizer 클래스

## StringTokenizer란

- 문자열 구분자 문자를 이용해 문자열을 분리하는 클래스

## StringTokenizer의 초기화

  ```java
  StringTokenizer st = new StringTokenizer("abc,def,ghi", ","); // abc def ghi
  st = new StringTokenizer("230,0042,015,002", "0,"); // 23 42 15 2
  ```

## StringTokenizer의 메소드

  | 메소드 | 설명 |
  |-----------------|------|
  | `countTokens()` | 남아있는 토큰의 개수를 반환 |
  | `hasMoreTokens()` | 토큰이 남아있는지 여부 반환 |
  | `nextToken()` | 다음 토큰을 String으로 반환 |
