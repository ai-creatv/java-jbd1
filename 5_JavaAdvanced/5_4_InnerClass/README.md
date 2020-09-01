# 내부 클래스 (Inner Classes)

## 내부 클래스란

- 클래스 내부에 선언하는 클래스로 중첩 클래스(Nested Class)라고도 부름
- `HAS-A` 관계에 있는 클래스가 해당 클래스에서만 사용될 경우 주로 사용

## 내부 클래스의 종류

- 클래스 영역에 선언
  - 인스턴스 내부 클래스: 외부 클래스의 멤버 변수처럼 사용 가능
  - 클래스 내부 클래스: static이 붙은 정적인 내부 클래스
- 로컬 영역에 선언
  - 로컬 내부 클래스: 선언된 영역의 Scope 내에서 사용 가능
  - 익명 내부 클래스: 객체를 일회성으로 생성하기 위한 이름이 없는 클래스

## 다양한 내부 클래스

### 인스턴스 내부 클래스 (Instance Inner Class)

- 클래스 영역에 `static` 키워드 없이 선언된 클래스
- 외부 클래스의 private을 포함한 모든 멤버에 접근 가능
- 외부 클래스 객체를 통해서만 생성 가능
- static 멤버 변수는 사용할 수 없으나, `static final`은 사용 가능

  ```java
  class Outer {
      class InstanceInner {
          int innerMemberVar = 1;
          //static int staticMemberVar = 1;
          static final int CONSTANT_VAR = 10;

          void innerMethod() {
              System.out.println(innerMemberVar);
              System.out.println(outerMemberVar);
          }
      }

    private int outerMemberVar = 2;

    void outerMethod() {
        IstanceInner obj = new InstanceInner();
        obj.innerMethod();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }

  }
  ```

- 외부 클래스의 멤버 변수와 이름이 겹치는 경우 `this` 활용

  ```java
  class Outer {
      class InstanceInner {
          int var = 1;

          void innerMethod() {
              System.out.println(var);
              System.out.println(this.var);
              System.out.println(Outer.this.var);
          }
      }

    private int var = 2;

    public static void main(String[] args) {
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }

  }
  ```

### 클래스 내부 클래스 (Class Inner Class)

- 클래스 영역에 `static` 키워드와 함께 선언된 내부 클래스
- 외부 클래스 객체가 없어도 생성 가능
- 외부 클래스의 private을 포함한 모든 멤버에 접근 가능
- static 멤버 변수를 가질 수 있음

  ```java
  class Outer {
      static class ClassInner {
          int innerVar = 1;
          static int staticInnerVar = 100;

          void innerMethod() {
              Outer outer = new Outer();
              System.out.println(outer.outerVar);
              System.out.println(innerVar);
          }
      }

      private int outerVar = 2;

      void outerMethod() {
          ClassInner inner = new ClassInner();
          inner.innerMethod();
      }

      public static void main(String[] args) {
          Static inner = new StaticInner();
          inner.innerMethod();
      }
  }
  ```

### 로컬 내부 클래스 (Local Inner Class)

- 클래스 영역이 아닌 로컬 영역에서 선언된 클래스
  - 메소드, 생성자, 초기화 블록의 내부
- 정적 변수는 가질 수 없으나, static final 변수는 가질 수 있음
- 로컬 영역의 변수 다음과 같은 사항을 따름
  - Java1.7: final로 선언된 변수에만 접근 가능
  - Java1.8: 모든 변수에 접근 가능하나, final로 간주되어 새로운 값 할당 불가

  ```java
  void outerMethod() {
      int var = 1; // 메소드 호출 스택

      class LocalInner {
          void innerMethod() {
              System.out.println(var);
          }
      }

      LocalInner inner = new LocalInner(); // 힙 영역
      inner.innerMethod();
  }
  ```

### 익명의 내부 클래스 (Anonymous Inner Class)

- 로컬 내부 클래스와 동일하나, 이름이 없어 선언 즉시 한 번 사용 가능
- 추상 클래스나 인터페이스의 구현에 많이 사용

  ```java
  interface IFoo {
      void do();
  }

  class AnonymousInnerClassTest {
      void useFoo(IFoo foo) {
          foo.do();
      }

      public static void main(String[] args) {
          useFoo(new IFoo() {
              @Override
              void do() {
                  System.out.println("Do!");
              }
          });
      }
  }
  ```
