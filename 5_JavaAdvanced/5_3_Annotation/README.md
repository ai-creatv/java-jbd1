# 애노테이션 (Annotations)

## 애노테이션이란

- 애노테이션의 사전적인 의미는 _주석_
- JVM, 컴파일러, 프레임워크 등에게 전달하는 메타데이터로 사용됨

## 기본 애노테이션

| 애노테이션 | 설명 | 비고 |
|-----------|------|-----|
|@Override  | 상속하여 오버라이드된 메소드 | |
|@Deprecated | 앞으로 사라질 예정임을 표기 | |
|@SuppressWarnings | 컴파일러에게 특정 경고 메세지를 무시하도록 한다. | eg. @SuppressWarnings("unused") |
|@FunctionalInterface | 함수형 인터페이스임을 표기 (Lambda) | |

## 애노테이션의 구성 요소

- 애노테이션의 작성
  - 추상 메소드와 유사한 형태로 구현

```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) // 메타 애노테이션
@Retention(RetentionPolicy.SOURCE)                                     // 메타 애노테이션
public @interface SuppressWarnings {                                   // 애노테이션 선언
    String [] value();                                                 // 애노테이션 속성
}
```

- 애노테이션의 사용
  - key=value 형태로 애노테이션에 속성의 값 전달

```java
@SuppressWarnings(value = {"unused", "rawtypes"}) // 키 = 값 배열
@SuppressWarnings(value = "unused")               // 값이 하나인 경우 배열 생략 가능
@SuppressWarnings({"unused", "rawtypes"})         // 속성이 value 하나인 경우 키 생략 가능

@CustomAnnotation(key1 = "value1", key2 = {"value2", "value3"}) // 속성이 여러개인 경우 키를 여러개 사용
```

- Target 설정
  - 애노테이션을 사용할 수 있는 대상을 설정
  - ElementType 열거형 상수 사용

    | `ElementType` | 범위 |
    |--------|------|
    |`TYPE` | 클래스, 인터페이스, 애노테이션, 열거형 |
    |`FIELD` | 필드(멤버 변수), 열거형 상수 |
    |`METHOD` | 메소드 |
    | `PARAMETER` | 메소드의 파라미터 |
    | `CONSTRUCTOR` | 생성자 |
    | `LOCAL_VARIABLE` | 로컬 변수 |
    | `ANNOTATION_TYPE` | 애노테이션 |
    | `PACKAGE` | 패키지 |

- Retention 설정
  - 애노테이션 정보를 언제까지 유지할 것인지 설정
  - RetentionPolicy 열거형 상수 사용
  - reflection: java.lang.reflect API

    | `RetentionPolicy` | 범위 |
    |------------------|------|
    | `SOURCE` | 컴파일러가 사용. 빌드된 .class 파일에는 포함되지 않음 |
    | `CLASS` | .class 파일에 포함되나, VM이 사용하지 않으며 reflection에 정보를 포함하지 않음 |
    | `RUNTIME` | .class에 포함, VM에서 인식, reflection에 정보를 포함 |

## 사용자 정의 애노테이션

- 사용자 정의 애노테이션 구현

  ```java
  @Retention(RUNTIME)
  @Target(FIELD)
  public @interface CustomAnnotation {
      String value();
      String valueTwo() default "기본값";
  }
  ```

- 사용자 정의 애노테이션 사용

  ```java
  class CustomAnnotationUsage {
      @CustomAnnotation("game")
      String gameName = "여러분의 틱택토";
      @CustomAnnotation(value = "server", valueTwo = "localhost")
      String serverIP;
      @CustomAnnotation("game")
      String gameMode = "AI vs. AI";
      @CustomAnnotation(value = "server", valueTwo = "8888")
      String serverPort;
  }
  ```
  
- Reflection을 이용하여 애노테이션에 할당된 값 사용

  ```java
  class CustomAnnotationTest {
    public static void main(String[] args) throws Exception {
        CustomAnnotationUsage obj = new CustomAnnotationUsage();
        Map<String, Object> gameProp = new HashMap<>();
        Map<String, Object> serverProp = new HashMap<>();

        Field[] fields = CustomAnnotationUsage.class.getDeclaredFields();
        for (Field field: fields) {
            CustomAnnotation annotation = field.getDeclaredAnnotation(CustomAnnotation.class);
            if (field.get(obj) == null) {
                field.set(obj, annotation.valueTwo());
            }
            if (annotation.value().equals("game")) {
                gameProp.put(field.getName(), field.get(obj));
            } else {
                serverProp.put(field.getName(), field.get(obj));
            }
        }

        System.out.println(gameProp);
        System.out.println(serverProp);

      }
  }
  ```