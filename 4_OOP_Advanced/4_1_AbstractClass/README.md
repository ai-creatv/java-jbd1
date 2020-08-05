# 추상 클래스 (Abstract Class)

## 추상 클래스란

- 일부 메소드가 구현되지 않고 선언만 되어 있는 클래스
  - 자식 클래스에서 반드시 구현해야 하는 메소드를 `abstract`로 선언
  - 필요한 모든 클래스가 구현될 수 있도록 강제

## 추상 클래스의 선언

- `abstract` 키워드를 이용해 클래스를 선언
- `abstract` 키워드를 이용해 메소드를 선언

  ```java
  abstract class AbstractFoo {
      public void method() {
          return;
      }

      public abstract void abstractMethod();
  }
  ```
