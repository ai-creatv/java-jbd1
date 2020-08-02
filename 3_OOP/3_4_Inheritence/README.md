# 상속 (Inheritence)

## 상속이란

- 클래스의 모든 멤버 변수 및 메소드를 계승하여 새로운 클래스를 생성하는 것
- 상속 대상 - 조상 클래스, 부모 클래스, 상위 클래스, 슈퍼 클래스
- 상속 결과 - 자손 클래스, 자식 클래스, 하위 클래스, 서브 클래스
- 상속 대상일 필요 조건을 달성하므로 `IS-A 관계`라고도 부른다.

## 클래스의 관계

### 클래스의 상속

- 부모 클래스

  ```java
  public class Person {
      String name;

      public void work() {
          System.out.println("일하기");
      }

      public void sleep() {
          System.out.println("잠자기");
      }
  }
  ```

- 자식 클래스

  ```java
  public class Developer extends Person {
      String mainLang;

      public void writeCode() {
          System.out.println("코딩하기");
      }
  }
  ```

  ```java
  public class Student extends Person {
      String major;

      public void writeCode() {
          System.out.println("밤새 코딩하기");
      }
  }
  ```

### 클래스의 포함

- 상속과 유사하나, 한 클래스가 다른 클래스의 인스턴스를 포함하는 관계로 되어 있다.
- 내부에 포함하고 있어, `HAS-A` 관계라고 부른다.
- 클래스 컴포지션 (Composition)이라 부른다.

  ```java
  public class MainMachine {
      String model;

      public MainMachine(String model) {
          this.model = model;
      }
  }
  ```

  ```java
  public class Developer extends Person {
      MainMachine machine = new MainMachine("Macbook Air");

      public void writeCode() {
          System.out.println(machine.model + "(으)로 코딩하기");
      }
  }
  ```

## 메소드 재정의

- 메소드의 기능을 재정의하는 것을 메소드 재정의 (Method overriding)이라 부른다.

  ```java
  public class Person {
      public void writeCode() {
          System.out.println("아무 코드나 일단 적어보았다.");
      }
  }
  ```

  ```java
  public class Developer extends Person {
      @Override
      public void writeCode() {
          System.out.println("깔끔하고 예쁜 코드를 적어보았다.");
      }
  }
  ```

## super 키워드

- `this`가 현재 객체를 참조하듯, `super`는 부모 객체를 참조한다.
- `super`로 부모의 부모 객체에는 접근할 수 없다.

  ```java
  public class Foo {
      String x = "foo";
  }

  public class Bar extends Foo{
      String x = "bar";

      void method() {
          String x = "method";
          System.out.println(x);
          System.out.println(this.x);
          System.out.println(super.x);
      }
  }
  ```

- 부모의 생성자를 호출하는 `super`
- 반드시 생성자의 첫줄에만 올 수 있음

  ```java
  public class Foo {
      String x;

      public Foo(String x) {
          this.x = x;
      }
  }

  public class Bar extends Foo {
      String y;

      public Bar(String x, String y) {
          super(x);
          this.y = y;
      }
  }
  ```

