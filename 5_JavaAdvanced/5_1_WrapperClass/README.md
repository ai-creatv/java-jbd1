# Wrapper 클래스 (Wrapper Class)

## Wrapper 클래스란

- 기본형 타입을 객체로 사용하기 위한 클래스

## Wrapper 클래스의 종류

  | 기본형 | Wrapper 클래스 |
  |-------|----------------|
  | byte | Byte |
  | char | Character |
  | short | Short |
  | int | Integer |
  | long | Long |
  | float | Float |
  | double | Double |
  | boolean | Boolean |

## Wrapper 객체 생성

- 생성자를 이용한 객체 생성

  ```java
  Integer integer = new Integer(10);
  ```

- valueOf를 이용한 객체 생성

  ```java
  Integer integer = Integer.valueOf(10);
  ```

## Autoboxing & Unboxing

- 오토박싱 (Autoboxing)
  - Java1.5부터 추가된 기능으로, 객체로 다루어야 할 때 자동으로 Wrapper 클래스로 변경하는 기능
- 언박싱 (Unboxing)
  - Wrapper 객체를 기본형으로 자동으로 변경하는 기능

  ```java
  int i = 10;
  Integer wrapped = i;
  int b = 20 + wrapped;
  ```

## Wrapper 타입의 값 비교

- Wrapper 타입은 객체이므로, ==를 이용하여 값을 비교할 수 없다.

  ```java
  Integer intOne = new Integer(100);
  Integer intTwo = new Integer(100);

  System.out.println(intOne == intTwo); // false
  System.out.println(intOne.equals(intTwo)) // true
  System.out.println(intOne == 100) // true (Unboxing)
  ```

## 문자열의 기본 자료형 변환

- Parsing 정적 메소드를 이용한 변환

  ```java
  int x = Integer.parseInt("100");
  long y = Long.parseLong("512345124");
  ```

- Wrapper 객체로의 변환

  ```java
  Integer intObj = Integer.valueOf("1000");
  Integer intObjTwo = new Integer("1234");
  ```
