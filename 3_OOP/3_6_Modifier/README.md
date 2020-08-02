# 제어자 (Modifier)

## 제어자란

- 클래스, 변수, 메소드에 부가 기능을 부여하는 키워드
- 접근 제어자 (Access modifiers)
  - 접근할 수 있는 범위를 정하는 키워드
  - `public`, `protected`, `(default = package)`, `private`
- 그 외 제어자 (Other modifiers)
  - 특별한 기능을 부여하는 제어자
  - `static`, `final`, `abstract`, `synchronized`

## 제어자의 기능

### 접근 제어자

- 접근 가능한 범위를 정해, 데이터 은닉/보호 (Encapsulation) 기능을 추가한다.
- 접근 제어자별 접근 범위
  | 제어자 | 같은 클래스 | 같은 패키지 | 다른 패키지에 속한 자식 클래스 | 전체 |
  |-------|:------:|:------:|:----:|:----:|
  |`public`|O|O|O|O|
  |`protected`|O|O|O| |
  |`default`|O|O|||
  |`private`|O||||

- `private` 또는 `protected` 변수에 접근하기 위해 getter와 setter 사용

  ```java
  class public Foo {
      private int x = 0;
      private int y = 1;

      public void setX(int x) { // setter
          this.x = x;
      }

      public void setY(int y) { // setter
          if (y >= 0) {
            this.y = y;
          }
      }

      public int getX() { // getter
          return x;
      }

      public int getY() { // getter
          return y;
      }
  }
  ```

### 그 외의 제어자

- `final`
  - 더 이상 바뀔 수 없음을 의미
  - 클래스, 메소드, 변수에 사용할 수 있음
    - 클래스: 더 이상 상속이 불가능해진다.
    - 메소드: 자식 클래스에서 오버라이드할 수 없다.
    - 변수: 변수의 값이 초기화 이후에 변하지 않는다.
      - 생성자에서 초기화가 이루어지는 것을 `blank final` 변수라 한다.

      ```java
      public class Foo {
          final int x = 0; // final variable
          final int y; // blank finial variable

          public Foo(int y) {
            this.y = y; // blank final variable initialization
        }

      }
      ```

- `static`
  - 클래스 변수, 클래스 메소드 등을 선언하기 위해 사용

- `abstract`
  - 추상 클래스에서 사용

- `synchronized`
  - 동시성 프로그래밍에 사용

## 싱글톤 패턴 (Singletone)

- 객체가 단 하나만 존재할 수 있는 클래스
- `private` 생성자를 이용한다.

  ```java
  class SingletonClass {
    private static SingletoneClass instance = new SingletonClass();
    private SingletonClass() {}

    public static SingletonClass getInstance() {
        return instance;
    }
  }
  ```
