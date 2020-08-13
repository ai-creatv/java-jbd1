# 열거형 (Enumeration)

## 열거형이란

- 몇가지 한정된 상수로 표현될 수 있는 자료형을 구현
- `enum` 키워드를 이용하며, 내부적으로는 `java.lang.Enum` 클래스를 상속

## 열거형의 특징

- 접근 제한자는 `public`과 `default`만 사용 가능
- 다른 클래스를 상속받을 수 없으나, 인터페이스 구현은 가능
- 열거형 타입에는 열거형 상수와 null 값을 할당할 수 있음

## 열거형의 구현

- 일반적인 열거형의 구현

  ```java
  enum Job {
      STUDENT, MARKETING, DEVELOPER, CHIEF_EXECUTIONAL_OFFICER;
  }

  public class Main {
      public static void main(String[] args) {
          Job job = Job.STUDENT;

          if (job == Job.CHIEF_EXECUTIONAL_OFFICER) {
              System.out.println("사장님, 안녕하세요?");
          }

          switch (job) {
              case STUDENT: // case에서는 'Job.' 을 쓰지 않는다.
                  System.out.println("You will be a great one.");
                  break;
              case MARKETING:
                  System.out.println("You make things sold.");
                  break;
              case DEVELOPER:
                  System.out.println("You usually don't go home.");
                  break;
              case CHIEF_EXECUTIONAL_OFFICER:
                  System.out.println("You choose your company's fate.");
                  break;
              default:
                  System.out.println("I don't recognize what you do.");
          }
      }
  }
  ```

- 클래스 내부에서 열거형 구현

  ```java
  public class Foo {
      enum MyEnum {
          ONE, TWO;
      }
  }

  public class Main {
      public static void main(String[] args) {
          System.out.println(Foo.MyEnum.ONE);
      }
  }
  ```

- 열거형에 메소드 구현

  ```java
  enum Symbol {
      ONE, TWO, THREE, FOUR;

      public Symbol nextSymbol() {
          if(this.equals(ONE)) {
              return TWO;
          } else if(this.equals(TWO)) {
              return THREE;
          } else if(this.equals(THREE)) {
              return FOUR;
          } else {
              return ONE;
          }
      }
  }

  public class Main {
      public static void main(String[] args) {
          Symbol sym = Symbol.ONE; // ONE
          Symbol nextSym = sym.nextSymbol(); // TWO
          nextSym = nextSym.nextSymbol(); // THREE
      }
  }

  ```

- 열거형 생성자를 이용한 enum 상수 초기화
  - 열거형의 생성자는 항상 `private`이며 생략 가능

  ```java
  enum Family {
      FATHER("아버지"), MOTHER("어머니"), SON("아들"), DAUGHTER("딸"); // 생성자 호출
      private String koreanWord;

      Family(String koreanWord) { // private 생성자
          this.koreanWord = koreanWord;
      }

      public String getKoreanWord() {
          return koreanWord;
      }

      public void setKoreanWord(String koreanWord) {
          this.koreanWord = koreanWord;
      }
  }

  public class Main {
      public static void main(String[] args) {
          Family fam = Family.SON;
          System.out.println(fam.koreanWord) // 아들
      }
  }
  ```
