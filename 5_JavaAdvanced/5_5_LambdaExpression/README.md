# 람다식 (Lambda Expression)

## 람다식이란

- Java 1.8에서 추가된 함수형 프로그래밍 기법
- 객체지향 프로그래밍과 다르게, 비즈니스 로직만을 빠르게 구현하는 특징
- 객체지향 언어인 Java에서 메소드를 함수처럼 사용하는 형식

## 람다식의 예

### 배열의 정렬

- 기본 정렬 방식을 이용한 정렬

  ```java
  String [] strings = {"fast", "campus", "java", "backend", "school"};
  System.out.println(Arrays.toString(strings));
  Arrays.sort(strings);
  System.out.println(Arrays.toString(strings));
  ```

  ```java
  public int compare(String o1, String o2) {
      return o1.compareTo(o2);
  }
  ```

- 익명 내부 클래스를 이용한 정렬 방식 변경

  ```java
  Arrays.sort(strings, new Comparator<String>() { // 객체를 생성하여 전달
      @Override
      public int compare(String o1, String o2) {
          return o1.compareTo(o2) * -1; // 내림차순
      }
  });
  ```

- 람다식을 이용한 정렬 방식의 변경

  ```java
  Arrays.sort(strings, (o1, o2) -> {return o1.compareTo(o2) * -1;});
  ```

  ```java
  Comparator<String> comp = (o1, o2) -> {
      return o1.compareTo(o2) * -1;
  };
  Arrays.sort(strings, comp);
  ```

- 함수형 인터페이스 (Functional Interface)
  - 추상 메소드가 단 하나 존재하는지 검사

    ```java
    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
        ...
    }
    ```

## 람다식의 형식

  ```java
  (String x) -> { System.out.println(x); }

  (x) -> { System.out.println(x); }

  x -> System.out.println(x)

  () -> System.out.println("x");  // () 생략 불가능

  (x) -> {
      System.out.println(x);
      return x;
  }

  (x) -> "x: " + x

  // x -> "x :" + x               // () 생략 불가능
  ```

## 람다식의 변수 참조

- 익명 내부 클래스와 동일한 규칙으로 변수 참조
- 문법적으로 this의 사용법만 다름
  - 익명의 내부 클래스와 달리 외부 클래스를 참조

  ```java
  @FunctionalInterface
  interface FunctionalInterface {
      String method();
  }

  class Main {
      void functionalMethod(FunctionalInterface obj) {
          System.out.println(obj.method());
      }

      public static void main(String[] args) {
          functionalMethod(()-> {
              System.out.println("this: " + this);
              System.out.println("OuterClass.this: " + Main.this);
              return "Lambda expression used."
          });

          functionalMethod(new FunctionalInterface() {
              @Override
              String method() {
                  System.out.println("this: " + this);
                  System.out.println("OuterClass.this: " + Main.this);
                  return "Anonymous inner class used."
              });
      }

  }
  ```

## java.util.function API

- 자주 사용되는 함수형 인터페이스를 정의해 둔 API
- Consumer, Supplier, Function, Operation, Predicate 계열이 있다.

### Consumer 계열

- 