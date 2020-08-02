# 다형성 (Polymorphism)

## 다형성의 다양한 특징

- 부모 클래스 타입으로 자식 클래스 객체를 참조하는 특징

  ```java
  public class Foo {
      public void methodA() {
          return;
      }
  }

  public class Bar extends Foo {
      public void methodB() {
          return;
      }
  }

  public class Main {
      public static void main(String args[]) {
          Bar bar = new Bar();

          Foo foo = (Foo)bar;
      }
  }
  ```

- 부모 클래스로 자식 클래스를 참조한 경우, 자식 클래스의 메소드는 사용할 수 없다.

  ```java
  public class Main {
      public static void main(String args[]) {
          Bar bar = new Bar();
          Foo foo = (Foo)bar;

          foo.methodA(); // works
          // foo.methodB(); // error
      }
  }
  ```

- 자식 클래스로 부모 클래스를 참조하려 하면 java.lan.ClassCastException 오류 발생

  ```java
  public class Main {
      public static void main(String args[]) {
          Foo foo = new Foo();
          Bar bar;

          // bar = (Bar)foo; // error
          if (foo instanceof Bar) { // returns false
              bar = (Bar)foo;
          }
      }
  }
  ```

- 멤버 변수 재정의는 선언된 객체의 타입을 따른다.
- 메소드 오버라이딩은 메모리상의 객체의 타입을 따른다. (가상 메소드 호출; Virtual method call)

  ```java
  public class Foo {
      public String x = "Super";

      public void methodA() {
          System.out.println("Super");
      }
  }

  public class Bar extends Foo {
      public String x = "Sub";

      @Override
      public void methodA() {
          System.out.println("Sub");
          return;
      }
  }

  public class Main {
      public static void main(String args[]) {
          Bar bar = new Bar();
          Foo foo = (Foo)bar;

          System.out.println(bar.x); // Sub
          bar.methodA(); // Sub

          System.out.println(foo.x); // Super
          foo.methodA(); // Sub
      }
  }
  ```

- 공변 반환 타입 (Covariant return type)

  ```java
  class Foo {
      public Foo getInstance() {
          return this;
      }
  }

  class Bar extends Foo {
      public Bar getInstance() { // Foo 대신 Bar로 리턴 가능
          return this;
      }
  }
  ```
