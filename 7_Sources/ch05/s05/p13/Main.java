package ch5.s05.p13;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 람다식에 기존 메소드/생성자 사용
 * - 람다식에 기존에 구현되어 있는 내용을 재사용하고자 할 때
 */

public class Main {
    public static void main(String[] args) {
        // 클래스::인스턴스_메소드
        String [] strings = {"fast", "campus", "best", "academy"};
        Arrays.sort(strings, String::compareTo);
        // Comparator 인터페이스는 2개의 입력 o1, o2를 받음
        // compare(o1, o2) -> o1.compareTo(o2)
        // o1.인스턴스_메소드(o2) 로 호출되는 메소드가 사용됨
        System.out.println(Arrays.toString(strings));

        // 클래스::클래스_메소드
        Function<String, Integer> func = Integer::parseInt;

        // 인스턴스::인스턴스_메소드
        String s = "String";
        Predicate<String> pred = s::equals;
        System.out.println(pred.test("String"));
        System.out.println(pred.test("String2"));

        
        // 생성자를 andThen, compose 등과 함께 사용 가능
        
        // 클래스::new
        UnaryOperator<String> fnc = String::new;

        // 클래스[]::new  -> 배열 생성
        // Int입력받아서 String[]을 출력
        IntFunction<String[]> fnc2 = String[]::new;
        String [] strings1 = fnc2.apply(100);
    }
}
