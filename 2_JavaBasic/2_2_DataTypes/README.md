# 자료형 (Data Type)

## 자료형이란

- 변수의 종류, 타입
- 기본형 (Primitive Type)
  - 값을 변수에 직접 저장하는 자료형

    | 종류 |         자료형                   | 크기 (byte) |
    |-----|--------------------------------|------------|
    | 문자 | `char`                         | 2          |
    | 정수 | `byte`, `short`, `int`, `long` | 1, 2, 4, 8 |
    | 실수 | `float`, `double`              | 4, 8       |
    | 논리 | `boolean`                      | 1          |

    - 정수형의 값 표현 범위
      |  자료형  |      범위         |
      |--------|------------------|
      | `byte` | -2^7 ~ 2^7 - 1   |
      | `short`| -2^15 ~ 2^15 - 1 |
      | `int`  | -2^31 ~ 2^31 - 1 |
      | `long` | -2^63 ~ 2^63 - 1 |

    - 실수형의 값 표현 범위
      | 자료형   |       범위                    |  m  |  e  |
      |---------|-----------------------------|-----|-----|
      | `float` | -m \* 10^e ~ m \* 10^e      |  23 |  8  |
      | `double`| -m \* 10^e ~ m \* 10^e      |  52 |  11 |

- 참조형 (Reference Type)
  - 값을 직접 저장하지 않고, 값이 저장된 주소를 저장
    ex) `Date birthDay = new Date();`

## 여러가지 자료형

### 정수형

- 정수 리터럴
  - 진수 표기법
    | 진수법               | 접두어 |  예시      |
    |--------------------|-------|-----------|
    | 10진수(decimal)     |   -   |  `32`     |
    | 2진수(binary)       |  0b   |  `0b1011` |
    | 8진수(octal)        |  0    |  `0342`   |
    | 16진수(hexadecimal) |  0x   |  `0x4A`   |
  - 정수 리터럴은 기본적으로 `int` 자료형
  - `int` 범위를 넘어서는 리터럴의 경우 `L`을 붙여서 표기
    ex) `long largeValue = 100000000000L;`
  - 가독성 향상을 위해 세자리 수 마다 `_`를 이용해 천단위 표기
    ex) `long largeValue = 100_000_000_000L;`

### 실수형

- 실수 리터럴
  - 실수 리터럴은 기본적으로 `double` 자료형
  - `f`를 붙여 `float` 타입을 표현할 수 있음
    ex) `float value = 14.42f;`
  - `e`를 이용해 지수 표현을 할 수 있음
    ex) `double value = 1.42e3;` 1.42 * 10^3 = 1420

### 문자형

- [ASCII 코드](https://www.ascii-code.com/)
  - 작은 따옴표로 표현하며, 문자는 기본적으로 ASCII 코드로 저장됨
  ex) `char asciiCharacter = 'A';`
  - ASCII 코드의 특수 문자 입력

  |      의미        | 표시 |
  |-----------------|-----|
  |tab              | `\t`|
  |backspace        | `\b`|
  |newline          | `\n`|
  |form feed        | `\f`|
  | \               | `\\`|
  |carriage return  | `\r`|
  |'                | `\'`|
  |"                | `\"`|

- [유니코드 테이블](https://unicode.org/charts/)
  - 유니코드는 `\u` + 16진수로 표현
  ex) `char unicodeCharacter = '\u0041';`

### 논리형

- `true`, `false` 두 가지 값만이 허용된다.
  
  ```java
  boolean isTrue = true;
  boolean isFalse = false;
  ```

### 문자열

- 문자열은 참조형 자료형이며, 큰 따옴표로 표현한다.
  
  ```java
  String s = "문자열은 큰따옴표로 묶는다.";
  ```

- 문자열은 덧셈으로 이어 붙일 수 있다. 문자열로 변환이 가능한 자료형은 문자열로 변환되어 결합한다.

  ```java
  String s1 = "a" + "b" + "c";
  String s2 = 1 + "1" + 3;
  ```

### 형변환 (Type Casting)

#### 형변환 연산자

- 형변환 연산자는 ()로 변수 앞에 입력한다.
  ex) `int value = (int)10.8;` -> value = 10

#### 업캐스팅 (Upcasting)

- 값의 범위가 더 큰 자료형으로 변환하는 경우
  - 묵시적(Implicit)/명시적(Explicit) 방법 모두 사용 가능
  
    ```java
    byte x = 10;
    int y = (int)x;
    int z = x;
    ```

#### 다운캐스팅 (Downcasting)

- 값의 범위가 더 작은 자료형으로 변환하는 경우
  - 명시적인 방법으로만 캐스팅 가능

    ```java
    int x = 1024;
    // byte y = x;
    byte z = (byte)x;
    ```

    ```java
    long x = 100;
    float y = x;
    // long z = y;
    long z = (long)y;
    ```
