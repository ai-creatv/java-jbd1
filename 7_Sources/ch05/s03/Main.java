package s03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.*;

/**
 * 애노테이션 (Annotations)
 * - 애노테이션의 사전적 의미는? 주석
 * - JVM, 컴파일러, 프레임워크 등에서 사용할 수 있도록 전달하는 메타데이터
 *
 * 기본 애노테이션
 * - @Override, @Deprecated, @SuppressWarnings, @FunctionalInterface
 * - Deprecated: 앞으로 사용되지 않을 클래스/메소드/변수 ... 사용하지 말라는 의미
 * - SuppressWarnings: 특정 경고 메세지를 무시하도록 컴파일러에 전달
 *   - @SuppressWarnings("unused")
 */

// @Target, @Retention : 메타 애노테이션
// @Target: 애노테이션을 사용할 수 있는 대상을 설정
// TYPE: 클래스, 인터페이스, 애노테이션, 열거형
// FIELD: 필드(멤버 변수), 열거형 상수
// METHOD : 메소드
// PARAMETER : 메소드의 입력 파라미터
// CONSTRUCTOR : 클래스의 생성자
// LOCAL_VARIABLE : 로컬 변수
// MODULE : 모듈
// ANNOTATION_TYPE : 애노테이션
// PACKAGE : 패키지

// @Retention
// 애노테이션 정보를 어디까지 유지할 것인가를 결정하는 Policy
// SOURCE: 컴파일러가 사용. .java -> .class로 변경하는 과정에서 쓰임 .class파일에 포함x
// CLASS: .class에 포함. JVM에 올라오지는 않음
// RUNTIME: .class에 포함. JVM에 올라와서 Reflection API에서 사용 가능
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
@interface SuppressWarningsClone {
    String[] value();
}

/**
 * 멤버 변수를 대상으로 하는, Reflection API에서 쓸 수 있는 애노테이션
 * 애노테이션 속성은 String[]인 value와 "기본값" 기본값을 가지는 valueTwo로 이루어짐
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value();// 애노테이션 속성 (기본 속성 이름은 value)
    String valueTwo() default "기본값";
}

class AnnotationUsage {
    @MyAnnotation("game")
    String gameName = "여러분의 틱택토";

    // value가 String[]이므로 value=String[]로 넣어 줌
    @MyAnnotation(value={"server"}, valueTwo="localhost")
    String serverIP;


    // value가 String[]이지만, 길이가 1이면 String만 넣어주어도 됨
    @MyAnnotation(value="server", valueTwo="8080")
    String serverPort;

    @MyAnnotation("game")
    String gameMode = "AI vs. AI";

    @MyAnnotation(value="db", valueTwo="localhost")
    String database;
}

public class Main {
    @SuppressWarnings("unused")
    int x;
    public static void main(String[] args) throws IllegalAccessException {
        @SuppressWarnings("unused")
        int x;

        AnnotationUsage obj = new AnnotationUsage();
        Map<String, Object> gameProp = new HashMap<>();
        Map<String, Object> serverProp = new HashMap<>();
        Map<String, Object> dbProp = new HashMap<>();

        Field[] fields = AnnotationUsage.class.getDeclaredFields(); // 필드 정보 가져오는 부분 (Reflection API)
        for (Field field: fields) {
            MyAnnotation annotation = field.getDeclaredAnnotation(MyAnnotation.class); // 필드에서 Annotation 정보 가져오는 부분 (Reflection API)
            if (field.get(obj) == null) { // 필드 값이 비어있는 경우 valueTwo에서 가져온다
                field.set(obj, annotation.valueTwo());
            }
            if (annotation.value()[0].equals("game")) {
                gameProp.put(field.getName(), field.get(obj));
            } else if (annotation.value()[0].equals("server")) {
                serverProp.put(field.getName(), field.get(obj));
            } else {
                dbProp.put(field.getName(), field.get(obj));
            }
        }

        System.out.println(gameProp);
        System.out.println(serverProp);
        System.out.println(dbProp);




    }
}
