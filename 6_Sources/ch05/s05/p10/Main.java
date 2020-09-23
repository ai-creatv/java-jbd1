package ch5.s05.p10;

import java.util.function.*;

/**
 * andThen 메소드, compose 메소드
 * - andThen 메소드: A.andThen(B) -> A부터 실행하고 B를 실행
 *   - Consumer 계열, Function계열, Operator 계열의 default method로 구현
 * - compose 메소드: A.compose(B) -> B부터 실행하고 A를 실행
 *   - Function계열, Operator 계열의 default method로 구현
 */

public class Main {
    public static void main(String[] args) {
        // Consumer는 andThen만 있고 compose 없음
        Consumer<String> c0 = s -> System.out.println("c0:" + s);
        Consumer<String> c1 = s -> System.out.println("c1:" + s);
        Consumer<String> c2 = c0.andThen(c1);
        c2.accept("STRING");

        // Function 계열은 입력->출력 => 입력->출력 타입이 연쇄가 되어야 한다.
        Function<String, Integer> func1 = s -> s.length();
        Function<Integer, Long> func2 = value -> (long)value;
        Function<String, Long> func3 = func1.andThen(func2);
        System.out.println(func3.apply("Four"));

        Function<String, Long> func4 = func2.compose(func1);
        System.out.println(func4.apply("Four"));

        // 특이사항 있으면 내일 다시 한번 언급 해 드릴게요!
        BinaryOperator<String> op0 = (s1, s2) -> s1 + s2;
        UnaryOperator<String> fnc0 = (s2) -> s2;
        UnaryOperator<String> op1 = s -> s + ".";
        // Operator들을 섞어 쓰더라도... 중간에 Function계열이 있을수도 있기 때문에
        // 최종 조합 결과는 Function 계열로 받아 주어야 함.
        BiFunction<String, String, String> op2 =  op0.andThen(op1);
        Function<String, String> op3 = op1.compose(fnc0);


    }
}
