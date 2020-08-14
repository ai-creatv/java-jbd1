# 예외 처리 (Handling Exceptions)

## 오류와 예외

- 프로그램이 동작 중에 비정상 종료가 발생하는 상황
- 심각도에 따라 오류와 예외로 분류할 수 있음

### 오류 (Errors)

- 시스템의 메모리가 부족하거나, 무한히 메소드 호출이 발생하는 등 프로그램 복구가 불가능한 상황
- 오류가 발생하는 원인을 찾아서 제거하는 방법으로 해결

### 예외 (Exceptions)

- 오류에 비해 심각도가 낮으며, 프로그램의 정상적인 흐름을 방해
  ex) 파일명으로 파일을 읽으려 하는데, 파일을 찾을 수 없음
- 문제 상황을 해결하는 로직을 별도로 구성하여 해결 가능

### 예외 처리

- 예외가 발생했을 때, 이 상황을 감지하고 해결하기 위해 동작하는 코드
- try ~ catch 구문과 Exception 클래스와 그 자식 클래스를 활용

### Throwable 클래스

- Throwable 클래스는 Exception과 Error 클래스에 의해 상속
  - Exception
    - Checked Exceptions: 예외 처리되지 않으면 컴파일이 되지 않는 예외
    - Unchecked Exceptions: 예외 처리되지 않아도 컴파일이 되는 예외
  - Error: 프로그램이 복구 불가능한 상황

### Exception 클래스

- Throwable 클래스의 주요 메소드

  | 메소드 | 설명 |
  |-------|------|
  | `public String getMessage()` | 발생한 예외에 대한 메세지를 반환 |
  | `public String getLocalizedMessage()` | 오버라이드하여 추가 메세지 제공 (오버라이드하지 않으면 getMessage()와 동일) |
  | `public Throwable getCause()` | 예외의 원인이 되는 Throwable 객체 반환 |
  | `public void printStackTrace()` | 예외가 발생된 메소드가 호출될 때의 Method call stack을 출력 |

## 예외 처리 기법

### try ~ catch 구문

  ```java
  try {
      // 예외가 발생할 수 있는 코드 영역
      // 예외 발생 시 예외 객체를 던짐 (throw)
  } catch (Exception e) { // 던져진 예외를 받음 (catch)
                          // Exception의 자식 클래스로 지정하여 특정 클래스를 받는다.
      // 예외 상황을 처리하는 코드
  }
  ```

### 다중 예외 처리

- 여러 개의 catch 구문을 사용하면 다중 예외를 처리할 수 있음
- if ~ else if 구문처럼, 순차적으로 검사하면서 적용 가능한 예외를 처리
- 다형성이 적용되어, 자식 예외를 처리 가능

  ```java
  try {
      // 예외 발생 가능 코드 영역
  } catch (AException e) {
      // A예외 처리
  } catch (BException e) {
      // B예외 처리
  } catch (CException e) {
      // C예외 처리
  } catch (Exception e) {
      // 나머지 모든 예외 처리
  }
  ```

### try ~ catch ~ finally 구문

- try 구문 실행 중에 어떤 일이 발생해도 반드시 실행되어야 하는 구문은 finally 블록에 작성
- try 구문 내에 return문이 있는 경우에도 finally 블록은 실행됨
- try 구문 내에서 접근한 System 자원을 안전하게 복구하기 위해 사용

  ```java
  FileInputStream file = null;
  try {
      file = new FileInputStream(fileName);
      file.read();
  } catch (IOException e) {
      System.out.println("파일처리실패");
  } finally {
      if (file != null) {
          try {
              file.close();
          } catch (IOException e) {
              System.out.println("파일인풋스트림 종료 실패");
          }
      }
  }
  ```

### try ~ with ~ resources 구문

- Java1.7에서 추가된 기능
- AutoClosable 인터페이스를 구현하는 리소스를 자동으로 close 처리

  ```java
  try (FileInputStream file = new FileInputStream(fileName)) {
      file.read();
  } catch (IOException e) {
      System.out.println("파일처리실패");
  }
  ```

## 예외 처리 위임

### throws

- 호출한 메소드로 예외 처리를 전달하는 방식
- Checked Exception의 경우 throws로 위임 가능하나, 최종적으로 try ~ catch를 만나야 함

  ```java
  class CheckedException {
      void methodA() throws ClassNotFoundException {
          Class.forname("A Class");
      }

      void methodB() {
          try {
              methodA();
          } catch (ClassNotFoundException e) {
              ...
          }
      }
  }
  ```

- Unchecked Exception의 경우 throws로 위임하지 않아도 자동으로 전달

  ```java
  class UncheckedException {
      void methodA() {
          int x = 10;
          x = 10/0;
      }
      void methodB() {
          try {
            methodA();
          } catch (ArithmeticException e) {
              ...
          }
      }
  }
  ```

- 메소드를 오버라이드한 경우, 조상 클래스의 메소드보다 조상 예외는 던질 수 없음

  ```java
  class Foo {
      void methodA() throws IOException {}
  }

  class BarOne extends Foo{
      void methodA() throws IOException {} // possible
  }

  class BarTwo extends Foo{
      void methodA() throws FileNotFoundException {} // possible
  }

  class BarThree extends Foo{
      void methodA() throws Exception {} // *NOT* possible
  }

  ```

### throw

- 예외를 발생시키는 키워드
- new 키워드로 새 Exception 객체를 생성하여 예외 내용을 작성

  ```java
  void exceptMethod() throws Exception {
      ...
      if (Err) {
          throw new Exception("Some Error"); // 예외 발생 및 Message 전달
      }
      ...
  }
  ```

## 사용자 정의 예외 (Custom Exceptions)

- Exception 또는 RuntimeException 클래스를 상속하여 작성
  - Exception을 상속한경우 Checked Exception이 되어 반드시 예외를 처리해야 한다.

  ```java
  class MyException extends RuntimeException {
      enum ErrorCode {
          ERROR_A, ERROR_B;
      }

      private ErrorCode errorCode;

      public MyException(ErrorCode errorCode, String message) {
          super(message);
          this.errorCode = errorCode;
      }

      @Override
      public String getLocalizedMessage() {
          String message = getMessage();
          ...
          return localizedMessage;
      }
  }
  ```
