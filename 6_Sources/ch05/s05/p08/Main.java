package ch5.s05.p08;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Operator 계열
 * - 입력받은 타입과 동일한 타입의 출력을 하는 함수형 인터페이스
 * - Function 계열과 달리 입출력 타입이 다를 수 없다.
 */

public class Main {
    public static void main(String[] args) {
        // 입력이 1개인 것을 Unary를 붙여서 표현
        UnaryOperator<String> operator = s -> s + ".";
        System.out.println(operator.apply("왔다"));

        BinaryOperator<String> operatorTwo = (s1, s2) -> s1 + s2;
        System.out.println(operatorTwo.apply("나","왔다"));

        IntUnaryOperator op = value -> value * 10;
        System.out.println(op.applyAsInt(5));
        // LongUnaryOperator, DoubleUnaryOperator

        IntBinaryOperator op2 = (v1, v2) -> v1 * v2;
        System.out.println(op2.applyAsInt(3, 5));
        // LongBinaryOperator, DoubleBinaryOperator
    }
}
