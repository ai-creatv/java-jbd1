package ch5.s05.p11;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/**
 * Predicate 계열 기본 메소드/클래스 메소드
 * - and(), or(), negate() : 기본 메소드
 * - isEqual() : 클래스 메소드
 */

public class Main {
    public static void main(String[] args) {
        DoublePredicate p0 = x -> x > 0.5;
        DoublePredicate p1 = x -> x < 0.7;
        DoublePredicate p2 = p0.and(p1);
        DoublePredicate p3 = p0.or(p1);
        DoublePredicate p4 = p0.negate(); // not

        System.out.println(p0.test(0.9));
        System.out.println(p1.test(0.9));
        System.out.println(p2.test(0.9));
        System.out.println(p3.test(0.9));
        System.out.println(p4.test(0.9)); // not p0

        // 클래스 메소드
        Predicate<String> eq = Predicate.isEqual("String");
        System.out.println(eq.test("String"));
        System.out.println(eq.test("String!"));
    }
}
