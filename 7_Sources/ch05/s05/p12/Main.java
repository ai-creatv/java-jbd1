package ch5.s05.p12;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator 인터페이스의 클래스 메소드
 * - minBy, maxBy : Comparator를 입력받아 min, max 출력
 */

public class Main {
    public static void main(String[] args) {
        BinaryOperator<String> minBy = BinaryOperator.minBy((o1, o2) ->
                o1.length() > o2.length() ? 1 : -1);
        BinaryOperator<String> maxBy = BinaryOperator.maxBy((o1, o2) ->
                o1.length() > o2.length() ? 1 : -1);

        System.out.println(minBy.apply("abc","cd"));
        System.out.println(maxBy.apply("abc","cd"));

        System.out.println(minBy.apply("abc","cde"));
    }
}
