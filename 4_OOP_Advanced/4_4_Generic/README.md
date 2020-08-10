# 제네릭 (Generic)

## 제네릭이란

- 대상 객체의 타입을 입력받아 사용할 수 있는 형식
- 미리 사용할 수 있는 타입을 명시하여 컴파일 타임에 체크할 수 있음
  - 입력을 `Object`로 한 경우 런타임을 체크하기 위한 `instanceof`를 많이 사용해야 함
  - 제네릭을 사용할 경우 간결하게 코드를 작성할 수 있다.

## 제네릭 클래스

### 제네릭 타입

- 클래스와 인터페이스에 제네릭이 적용된 타입
- 클래스를 선언할 때에는 타입이 알려지지 않으며, 타입 파라미터를 사용

  ```java
  public class GenericClass<T> { // T: 타입 파라미터
      ...
  }

  public interface GenericInterface<T> { // T: 타입 파라미터
      ...
  }

  public class HashMap<K,V> { // K, V: 타입 파라미터
      ...
  }
  ```

- 제네릭 타입은 실제로 사용될 때 타입 파라미터에 자료형을 입력받는다.

  ```java
  GenericClass<String> generic = new GenericClass<String>();
  GenericClass<String> generic2 = new GenericClass<>();
  ```

### 타입 파라미터 주의점

- `static` 멤버 변수는 타입 파라미터를 사용할 수 없다.

  ```java
  public class Generic<T> {
      static T classVar; // not possible
      static void method(T localVar) {} // possible
  }
  ```

- `new` 키워드를 사용하여 객체 생성을 할 수 없다.

  ```java
  public class Generic<T> {
      T var = new T(); // not possible
  }
  ```

- `instanceof`의 피연산자로 사용할 수 없다.

  ```java
  public class Generic<T> {
      {
          Object obj = new Object();
          if(obj instanceof T) { // not possible
              ...
          }
      }
  }
  ```

### 제네릭 타입의 상속

- 부모 클래스 또는 인터페이스에 선언한 타입 파라미터는 반드시 자식에서도 선언
- 자식 클래스에서 추가적인 타입 파라미터 선언할 수 있다.

  ```java
  class Foo<T> {
      ...
  }

  interface IBar<D> {
      ...
  }

  class FooBar<C, T, D> extends Foo<T> implements IBar<D> {
      ...
  }
  ```

### 파라미터 타입의 제한

- `extends`를 이용하여 파라미터 타입을 제한할 수 있다.
  - 인터페이스의 경우에도 `extends` 키워드를 사용한다.
  - 클래스와 인터페이스를 동시에 제약하려면 `&`로 연결한다.
- 제한한 자료형의 자식 클래스는 모두 사용할 수 있다.

  ```java
  class Generic<T extends Number> {
      ...
  }

  class Generic<T extends Number & Cloneable> {
      ...
  }
  ```

## 제네릭 메소드

### 메소드에 선언된 제네릭

- 메소드의 리턴 타입 앞에 타입 파라미터 변수를 선언하여 사용

  ```java
  class GenericMethod {
      public <T> T method(T x) {
          return x;
      }
  }
  ```

- 와일드카드
  - `<?>` => `<? extends Object>`와 동일
  - `<? extends T>` => 와일드카드의 상한을 제한
  - `<? super T>` => 와일드카드의 하한을 제한

  ```java
  class Foo {
      ...
  }

  class Bar extends Foo {
      ...
  }

  class Generic<T> {
      ...
  }

  class WildCard {
      public void method1(Generic<?> x) {}
      public void method2(Generic<? extends Foo> x) {}
      public void method3(Generic<? super Bar> x) {}
  }
  ```
