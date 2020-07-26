# 문자열 (Strings)

## 문자열의 특징

- 클래스로 구현되어 있다.
- 내부에 문자의 배열로 데이터가 구현되어 있다.
- 한번 만든 문자열은 변하지 않는다. (Immutable)

## 문자열의 생성

- new 키워드를 이용하여 생성

  ```java
  String string = new String("문자열 생성");
  ```

- new 키워드 없이 생성 (권장)

  ```java
  String string = "문자열 생성";
  ```

## 문자열 메소드

| 메소드 | 메소드 선언 | 설명 |
|-------|-----------|------|
|length()| `public int length()`| 문자열의 길이를 출력 |
|charAt()| `public char charAt(int index)`| index번째에 위치한 문자 출력 |
|indexOf()| `public int indexOf(char ch)` | ch가 위치한 index 출력. 없을 시 -1 |
|equals()| `public boolean equals(Object anObject` | anObject와 비교한 결과 출력 |
|equalsIgnoreCase()| `public boolean equalsIgnoreCase(String anotherString)` | 대소문자 구분없이 anotherString과 비교 결과 출력 |
|replace()| `public String replace(char odlChar, char newChar)` | oldChar를 찾아 newChar로 변경된 문자열 출력 |
|substring()| `public String substring(int beginIndex, int endIndex)` | 문자열을 beginIndex부터 endIndex-1까지 잘라서 출력 |
|trim()| `public String trim()` | 문자열 좌우 공백을 없앤 결과를 출력 |
|matches()| `public boolean matches(String regex)` | 문자열을 정규표현식 regex 확인 결과 출력 |
|split()| `public String[] split(String regex)` | 문자열을 정규표현식 형태로 나눈 후 배열로 출력 |
