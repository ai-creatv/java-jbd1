# 자료의 입출력 (Inputs and Outputs)

## 출력 메소드

- 포맷 문자열을 이용한 문자열/기본형 출력
- 객체를 직접 출력

### PrintStream의 출력 메소드

| 메소드      | 메소드 선언 | 설명 |
|-----------|-----------|----|
| print()   | `public void print(Object obj)` | obj를 스트림으로 출력한다.  |
| println() | `public void println(Object x)` | x를 스트림으로 출력하고 줄바꿈한다. |
| printf()  | `public PrintStream printf(String format, Object ... args)`| Format 맞추어 args를 출력한다. |

### 포맷 문자열 지시자

| 지시자 | 설명 |
|------|-----|
|  %b  | boolean |
|  %d  | decimal integer |
|  %o  | octal |
|%x, %X| hexadecimal |
| %f   | decial float|
| %e, %E | exponent |
| %c     | character  |
| %s    | string |
| %n    | newline |

### 지시자 자릿수 표현

| 표현  |   설명     |
|------|-----------|
| %nd  | 최소 n칸을 사용하고 숫자를 오른쪽 정렬 |
| %-nd | 최소 n칸을 사용하고 숫자를 왼쪽 정렬 |
| %0nd | 최소 n칸을 사용하고 빈칸은 0으로 채움 |
| %n.mf | 최소 n칸을 사용하고 소수점 이하 m자리까지 표현 |

### 시간을 출력하는 포맷 문자

| 지시자  |     설명     | 예시 |
|-------|--------------|----|
| %tH   | 24시간 표기법의 시간 | 22 |
| %tl   | 12시간 표기법의 시간 | 08 |
| %tM   | 분 | 59 |
| %tS   | 초 | 60 |
| %tp   | 오전/오후 | AM |
| %tT   | %tH:%tM:%tS | 23:11:06 |
| %tR   | %tH:%tM | 16:42 |
| %tr   | %tl:%tM:%tS %tp | 04:15:55 PM |

### 날짜를 출력하는 포맷 문자

| 지시자  |  설명     | 예시 |
|-------|----------|------|
|%tB| 월 | March |
|%tb| 축약형 월 | Mar |
|%tm| 월 | 03 |
|%tA| 요일 | Monday |
|%ta| 축약형 요일 | Mon |
|%tY| 년도 | 2020 |
|%ty| 축약형 년도 | 20 |
|%td| 일 | 09 |
|%te| 일 | 9 |
|%tZ| Time Zone | KST |
|%tD| %tm/%td/%ty | 02/24/89 |
|%tF| %tY-%tm-%td | 1989-02-24 |
|%tc| %ta %tb %td %tT %tZ %tY | Sun Feb 24 07:20:15 KST 1989 |

## 입력 메소드

- Scanner 클래스를 이용하여 입력받을 수 있다.

  ```java
  import java.util.Scanner;

  ...

  Scanner scanner = new Scanner(System.in);
  ```

- Scanner 클래스의 주요 메소드

| 메소드 | 메소드 선언 | 설명 |
|-------|-----------|------|
|next()| `public String next()` | 공백을 기준으로 한 단어씩 입력받는다. |
|nextLine()| `public String nextLine()` | 한 줄 전체를 입력받는다. |
|nextInt()| `public int nextInt()` | `int` 값을 입력받는다. |
|nextDouble() | `public double nextDouble()` | `double` 값을 입력 받는다. |
|close() | `public void close()` | 입력 스트림을 종료한다. |
