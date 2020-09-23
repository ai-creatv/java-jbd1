package ch5.s05.p09;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Predicate 계열
 * - 논리 판단을 해 주는 함수형 인터페이스
 * - 입력을 받아서 boolean 타입 출력으로 변환
 */

public class Main {
    public static void main(String[] args) {
        Predicate<String> pred = (s) -> s.length() == 4;
        System.out.println(pred.test("abcd"));
        System.out.println(pred.test("abcde"));

        BiPredicate<String, Integer> pred2 = (s, v) -> s.length() == v;
        System.out.println(pred2.test("abcd", 23));
        System.out.println(pred2.test("abcde", 5));

        IntPredicate pred3 = x -> x > 0;
        // LongPredicate, DoublePredicate
    }
}
