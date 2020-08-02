# 클래스 (Classes)

## 클래스와 객체

- 클래스: 객체를 생성하기 위해 사용하는 추상화된 설계도
- 객체: 클래스가 구체화하여 값으로 생성된 것
  - Instantiation: 클래스에서 객체를 생성하는 과정
  - Object, Instance: Instantiation으로 인해 생성된 객체

### 클래스의 구성

```java
public class Car {
    int speed = 0; // 멤버 변수 (속성)

    void move() { // 멤버 함수 (메소드)
        this.speed = 10;
    }
}
```

- 속성(Attribute, field) - 클래스에 속하는 멤버 변수, 상태, 필드
- 메소드(Method) - 클래스에 속하는 멤버 함수, 행동

### 객체의 생성

```java
Car car = new Car();
클래스명 변수명 = new 클래스명();
```

- 클래스를 구체화하여 값을 생성한 것을 객체라 한다.
- 하나의 클래스로 여러개의 객체를 만들 경우, 같은 타입의 독립적인 객체가 된다.

### 클래스와 객체의 메모리 구조

- 클래스 영역 (Class Area, Method Area, Code Area, Static Area)
  - Field 정보
  - Method 정보
  - Type 정보
  - Constant Pool

- 스택 영역 (Stack Area)
  - Method 호출 시 선언된 로컬 변수

- 힙 영역 (Heap Area)
  - new 키워드로 생성된 객체

## 변수 (Variables)

- 로컬 변수와 멤버 변수

  | 구분 | 선언 위치 | 변수 종류 | 특징 |
  |-----|-----------|----------|------|
  |멤버 변수| 클래스 영역 | 클래스 멤버 변수 | `static` 키워드 o |
  |멤버 변수| 클래스 영역 | 인스턴스 멤버 변수 | `static` 키워드 x |
  |로컬 변수| 메소드 및 블록 내부 | 로컬 변수 | |
  |로컬 변수| 메소드 내부 | 파라미터 변수 | 메소드의 입력 인자 |

  ```java
  public class Variables {
    int instanceVar; // 인스턴스 멤버 변수
    static int classVar; // 클래스 멤버 변수

    public void method(int parameterVar) { // 파라미터 변수
        int localVar = 0; // 로컬 변수
    }
  }
  ```

### 인스턴스 멤버 변수 (Instance Variables)

- 인스턴스 변수는 객체를 생성할 때 힙 영역에 생성됨
- 인스턴스 변수는 힙 영역에 생성되므로 초기화가 이루어짐

  | 자료형 | 기본값 |
  |-------|--------|
  |`boolean`| false |
  |`char` | '\u0000' |
  |`byte`, `short`, `int` | 0 |
  |`long` | 0L |
  |`float` | 0.0f |
  |`double` | 0.0 |
  |Ref. type | `null` |

### 클래스 멤버 변수 (Class Variables)

- 클래스 멤버 변수는 프로그램 시작 시 클래스 영역에 생성됨
- 객체가 아닌 클래스로 접근하는 것이 권장됨 (객체로 접근도 가능하나 비권장)

  ```java
  public class Foo {
      static int classVar = 10;
  }

  Foo.classVar = 0; // Recommended

  Foo foo = new Foo();
  foo.classVar = 0; // Not recommended
  ```

### 로컬 변수 (Local Variable)

- 메소드 또는 중괄호 블록 내부에서 생성되는 변수
- 스택 영역에 생성되며, 초기화가 이루어지지 않음
- 생명 주기(Life cycle)은 생성된 중괄호 블록이 종료될 때 까지

  ```java
  void method(int paramVar) {
      int localVar;
      // System.out.println(localVar);  // 초기화가 이루어지지 않음
      localVar = 10;
      System.out.println(localVar);
      {
          int localVar2 = 10;
          System.out.println(localVar2);
      }
      // System.out.println(localVar2); // 생명주기가 끝남
  }
  ```

## 메소드 (Methods)

### 메소드란

- 객체가 하는 동작을 정의하는 어떠한 작업을 수행하는 코드의 집합
- 코드의 중복을 방지하고 유지보수성을 향상시키기 위해 사용

```java
public class Car {
    String name;

    void printModel() { // 메소드의 정의 (Method definition)
        System.out.println(name);
    }
}

Car hyundai = new Car();
Car kia = new Car();

hyundai.name = "Hyundai";
kia.name = "Kia";

hyundai.printModel(); // 메소드의 호출 (Method call)
kia.printModel();
```

### 메소드의 구현

- 메소드는 함수의 형태로 구성된다.
  - 파라미터 (Parameters, 입력)
  - 실행문 (Executional Statements)
  - 리턴 값 (Return Value, 출력)

- 함수의 작성

  ```java
  public int add(int x, int y) {
      return x + y;
  }
  
  제한자 리턴타입 메소드명(파라미터타입1 파라미터이름1, 파라미터타입2 파라미터이름2, ...) {
      // 실행문
  }
  ```

- 가변 인자 (Variable Arguments)
  - 입력 인자의 개수가 정해지지 않은 경우

  ```java
  public int sumAll(int... params) {
      int sum = 0;
      for (int i: params) {
        sum += i;
      }
      return sum;
  }
  ```

- 기본형 vs. 참조형 변수
  - 기본형: 메소드 인자로 값이 전달됨 (Call by value)
  - 참조형: 메소드 인자로 참조가 전달됨 (Call by reference)

  ```java
  public class Foo {
      int value;
  }

  public class Bar {
      public void swapPrimitive(int x, int y) {
          int temp = x;
          x = y;
          y = temp;
      }

      public void swapReference(Foo x, Foo y) {
          int temp = x.value;
          x.value = y.value;
          y.value = x.value;
      }
  }

  Bar bar = new Bar();

  int x = 1, y = 10;
  bar.swapPrimitive(x, y);
  System.out.println(x); // 1
  System.out.println(y); // 10

  Foo foo1 = new Foo(1);
  Foo foo2 = new Foo(10);
  bar.swapReference(foo1, foo2);
  System.out.println(foo1.value); // 10
  System.out.println(foo2.value); // 1
  ```

- 클래스 메소드 (Class method)
  - `static` 키워드를 이용하여 선언된 메소드
  - 인스턴스가 아닌 클래스에 속하는 메소드
  - 대표적으로 main 메소드가 클래스 메소드이다.

  ```java
    public class Foo {
      static public void main(String args[]) {
          // class method
      }
  }
  ```

- 메소드 호출 스택 (Method Call Stack)
  - 메소드가 호출될 때 마다 메소드 동작과 로컬 변수가 쌓이는 메모리 영역
  - 메소드가 종료될 때 메모리가 함께 반환됨

### 메소드 오버로딩

- 동일 기능의 함수를 추가로 구현하는 방법
- 입력 파라미터를 달리하는 동일 함수명으로 구현한다.

  ```java
  public class Foo {
      public int sumAll(int ... params) {
          int sum = 0;
          for (int i: params) {
              sum += i;
          }
          return sum;
      }

      public float sumAll(float ... params) {
          float sum = 0.0f;
          for (float x: params) {
              sum += x;
          }
          return sum;
      }
  }

  Foo foo = Foo();
  int sum1 = foo.sumAll(1, 2, 3, 4, 5);
  float sum2 = foo.sumAll(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
  ```

## 생성자 (Constructor)

- 클래스에서 인스턴스를 생성할 때 사용되는 메소드
  - `new` 키워드를 이용해 호출
- 기본 생성자 (Default Constructor)
  - 구현하지 않아도 자동으로 생성되는 생성자
  - 아무런 동작도 하지 않고, 객체만을 생성

- 파라미터 생성자 (Parameter Constructors)
  - 입력 파라미터를 받는 생성자
  - 여러개의 파라미터 생성자를 오버로딩할 수 있음
  - 보통 멤버 변수를 초기화하는 동작 수행

```java
public class Foo {
    int x;
    int y;
    String z;

    // public Foo() {} // Default Constructor

    public Foo(int a, int b, String c) { // Parameter Constructor
        x = a;
        y = b
        z = c;
    }
}
```

## this 키워드

- 객체가 스스로를 가르키는 참조
- 멤버 변수와 로컬 변수의 이름이 같을 때, 멤버 변수임을 명시

  ```java
  public class Foo {
      int x;
      int y;

      public Foo(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }
  ```

- 생성자를 호출하는 데에도 사용할 수 있다.
- 반드시 생성자의 첫 줄에서만 사용해야 한다.

  ```java
  public class Foo {
      int x;
      int y;
      String z;

      public Foo(int x, int y, String z) {
          this.x = x;
          this.y = y;
          this.z = z;
      }

      public Foo(String z) {
          this(0, 0, z);
      }

      public Foo(int x, int y) {
          this(x, y, "Nothing");
      }
  }
  ```

## Getter와 Setter

- 클래스의 멤버 변수를 간접적으로 다룰 수 있게 하는 메소드
- 멤버 변수의 캡슐화(Encapsulation)를 구현하기 위해 사용

  ```java
  public class Foo {
      private int x;

      public int setX(int x) {
          this.x = x;
      }

      public void getX() {
          return x;
      }
  }
  ```

## 초기화 블록 (Initializer)

- 클래스 또는 인스턴스를 생성할 때 단 한번 실행되는 코드 블록

  ```java
  public class Foo {
      static int classVar;
      int instanceVar;

      static {  // Class Initializater
          classVar = 100;
      }

      {  // Instance Initializer
          instanceVar = 10;
      }

      static {
          // May be more than one block
      }
  }
  ```
