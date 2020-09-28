# java.lang 패키지

## java.lang

- Java에서 가장 기본적이며 자주 사용되는 클래스를 모은 패키지
- 별도로 import하지 않아도 사용이 가능한, Java의 기본 중의 기본

## Object Class

- 모든 클래스의 조상 클래스로, 클래스가 갖춰야할 기본 기능을 제공
- 필요한 경우 Object 클래스에 정의된 메소드를 Override하여 사용

  | 메소드 | 설명|
  |--------|-----|
  |`public final native Class<?> getClass()` | 현재 객체의 클래스를 반환한다. |
  |`public native int hashCode()` | 현재 객체의 해시코드 값을 반환한다. |
  |`public boolean equals()` | 현재 객체와 대상이 같은 객체를 참조하는지 여부를 반환한다. |
  |`public String toString()` | 객체를 문자열로 변환하여 반환한다. |
  |`proteted native clone() throws CloneNotSupportedException` | 객체를 복사하여 새로운 객체로 반환한다. |

### equals()

- Object 클래스의 equals() 메소드 구현
  - 객체의 참조만을 비교

  ```java
  public boolean equals(Object obj) {
      return (this == obj);
  }
  ```

- String 클래스의 equals() 메소드 구현 (Overriding)
  - 효율적으로 객체의 내용이 동일한지 비교

  ```java
  public boolean equals(Object anObject) {
      if (this == anObject) {
          return true;
      }
      if (anObject instanceof String) {
          String aString = (String)anObject;
          if (!COMPACT_STRINGS || this.coder == aString.coder) {
              return StringLatin1.equals(value, aString.value);
          }
      }
      return false;
  }
  ```

### hashCode()

- 객체를 구분하기 위해 사용하는 정수값(해시코드)을 반환
  - 프로그램 내에서 객체마다 유일하므로 주소값처럼 사용 가능
- `native` 메소드이므로 구현 내용을 볼 수 없음
- hashCode()의 제한 사항
  - 한 객체의 hashCode()를 여러번 호출할 경우, equals()에 사용하는 값이 변하지 않으면 동일한 값을 반환해야 한다.
  - equals() 메소드가 같다고 판단한 두 객체의 hashCode() 반환값은 같아야 한다.
  - equals() 메소드가 다르다고 판단한 두 객체의 hashCode()가 반드시 다를 필요는 없으나, 다른 값이 나오면 HashTable 성능이 향상된다.

### clone()

- 자신을 복제하여 새로운 객체를 생성하는 메소드
- 배열을 복제할 경우 새로운 객체를 생성하므로 원본을 훼손하지 않을 수 있음
- clone() override 시 `Cloneable` 인터페이스를 구현해야 함

  ```java
  int [] ints = {1, 2, 3, 4, 5};
  int [] ints2 = ints.clone();
  ```

### getClass()

- Class 에 대한 정보를 담고 있는 Class 객체를 반환
- 객체의 getClass() 메소드 또는 해당 클래스의 정적 변수 class를 이용 가능

  ```java
  class Foo {
      public void methodA() {
          System.out.println("method A called.");
      }
  }

  class FooTest {
      public static void main(String[] args) throws Exception {
          Foo foo = new Foo();
          Class fooClass = foo.getClass();

          System.out.println(fooClass.getName());
          System.out.println(fooClass.getDeclaredMethods().length);
          System.out.println(Foo.class.getDeclaredMethod("methodA").invoke(foo));
      }
  }
  ```

### System

- 실행 중인 OS와 interact하기 위한 클래스
- System 클래스의 주요 정적 변수

  | 속성 | 설명 |
  |------|-----|
  | `public static final PrintStream err` | 오류를 출력하기 위한 표준 출력 스트림 |
  | `public static final InputStream in` | 표준 입력을 처리하기 위한 입력 스트림 |
  | `public static final PrintStream out` | 표준 출력을 처리하기 위한 출력 스트림 |

- System 클래스의 주요 정적 메소드

  | 메소드 | 설명 |
  |-------|------|
  | `arraycopy()` | src 배열의 내용을 dst 배열로 복사한다. |
  | `currentTimeMillis()` | 현재 시스템 시간을 ms로 반환한다. |
  | `exit()` | 프로그램을 종료한다 |
  | `gc()` | GC를 요청한다. |
  | `getenv()` | 환경 변수의 값을 반환한다. |
  | `getProperties()` | 시스템 속성을 Property로 반환한다. |
  | `getProperty()` | 시스템 속성 값을 문자열로 반환한다. 없을 경우 null 또는 def를 반환 |
  | `identityHashCode()` | 객체의 해시코드 값을 반환한다. |
  | `lineSeparator()` | 시스템의 줄넘김 문자열을 반환한다. UNIX: `\n`, WINDOWS: `\r\n` |
  | `nanoTime()` | 시스템 시간을 ns로 반환한다. |
  | `setProperties()` | 시스템 속성을 한번에 설정한다. |
  | `setProperty()` | 시스템 속성을 하나씩 설정한다. |

  - 주요 Property

    | 속성 | 설명 |
    | `user.country` | OS 로케일 정보 |
    | `java.io.tmpdir` | 임시 경로 |
    | `line.separator` | 줄넘김 문자열 |
    | `user.home` | 유저 홈 경로 |
    | `file.separator` | 파일 경로 구분 |

### Math

- 수학 계산에 필요한 메소드를 가진 final 클래스

  | 메소드 | 설명 |
  |--------|-----|
  | `abs()` | 절대값을 반환한다. |
  | `ceil()` | 올림 값을 double로 반환한다. |
  | `floor()` | 내림 값을 double로 반환한다. |
  | `max()` | 두 값 중 더 큰 값을 반환한다. |
  | `min()` | 두 값 중 더 작은 값을 반환한다. |
  | `random()` | 0 이상 1.0 미만의 임의의 값을 반환한다. |
  | `round()` | 소수점 첫째자리에서 반올림한 정수 값을 반환한다. |
  | `addExact()` | 덧셈 연산으로, Overflow 발생 시 `ArithmaticException` 발생. |
  | `subtractExact()` | 뺄셈 연산으로, Overflow 발생 시 `ArithmaticException` 발생. |
  | `multiplyExact()` | 곱셈 연산으로, Overflow 발생 시 `ArithmaticException` 발생. |
