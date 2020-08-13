# 인터페이스 (Interface)

## 인터페이스란

- 클래스를 사용하는 방식, 접점만을 선언하는 클래스와 유사한 틀
- 아무런 구현이 되어 있지 않으며, 모든 메소드가 추상 메소드

## 인터페이스의 특징

- `class`가 아닌 `interface` 키워드로 선언
  - `public` 또는 `default` 접근 제어자만 사용 가능
- 멤버 변수는 항상 `public static final`이며, 생략 가능
- 멤버 메소드는 항상 `public abstract`이며, 생략 가능
- 클래스와 달리 인터페이스는 여러 개 상속받을 수 있다.

  ```java
  public interface IFoo {
      public static final int MEMBER_VAR = 10;
      int MEMBER_VAR2 = 20; // public static final

      public abstract void methodA(int param);
      void methodB(int param); // public abstract
  }

  public class Foo implements IFoo {
      @Override
      void methodA(int param) {
          System.out.println(param);
      }

      @Override
      void methodB(int param) {
          System.out.println(param);
      }
  }
  ```

## 인터페이스간의 상속

- 인터페이스 간의 'IS-A' 관계
- 인터페이스가 인터페이스를 상속할 경우 `extends`로 상속
- 클래스-클래스와 달리 다중 상속 가능

  ```java
  interface Walkable {
      void walk();
  }

  interface Runnable {
      void run();
  }

  public interface Jumpable extends Walkable, Runnable {
      void jump();
  }

  public class Jumper implements Jumpable {
      @Override
      void walk() {
          System.out.println("walk");
      }

      @Override
      void run() {
          System.out.println("run");
      }

      @Override
      void jump() {
          System.out.println("jump");
      }
  }
  ```

## JDK 1.8

- 기본 메소드 (Default method): 자식 클래스에서 구현할 필요가 없는 메소드
  - 인터페이스에 `default` 메소드를 구현할 수 있다.
  - `default` 메소드는 항상 `public`이다.
  - 인터페이스의 철학과 맞지 않으나, 인터페이스가 개선되었을 때 손쉽게 기능 추가를 위해 만들어짐

  ```java
  interface IFoo {
      void abstractMethod();

      default void defaultMethod() { // 구현 클래스에서 구현할 필요가 없다.
          System.out.println("Default method");
      }
  }

  class SuperFoo {
      void defaultMethod() {
          System.out.println("Super method");
      }
  }

  class FooOne implements IFoo {
      void abstractMethod() {
          return;
      }
  }

  class FooTwo extends SuperFoo implements IFoo {
      void abstractMethod() {
          return;
      }
  }

  public class Main {
      public static void main(String[] args) {
          FooOne fooOne = new FooOne();
          fooOne.defaultMethod(); // Default method

          FooTwo fooTwo = new FooTwo();
          fooTwo.defaultMethod(); // Super method
      }
  }
  ```

- static 메소드: 클래스 메소드와 동일하게 사용 가능
  - 인터페이스 이름으로 호출 가능
  - 클래스 구현체의 이름으로는 호출할 수 없음

  ```java
  interface IFoo {
      static void staticMethod() {
          System.out.println("static method");
      }
  }

  class Foo implements IFoo {
  }

  public class Main {
      public static void main(String[] args) {
          IFoo.staticMethod(); // static method
          // Foo.staticMethod(); // not possible
      }
  }
  ```
