package ch5.s05.p05;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/**
 * Consumer 계열
 * - 파라미터 입력을 받아서 그것을 소비하는 Functional Interface
 * - accept 메소드를 사용: 리턴이 void인 특징
 */

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("A String.");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + "," + u);
        biConsumer.accept("StringA", "StringB");

        // 오토박싱/언박싱 사용 - 비효율적
        Consumer<Integer> integerConsumer = (x) -> System.out.println(x);
        integerConsumer.accept(5);

        // 기본형 입력을 하려고 할 경우, PConsumer (P:Primitive Type)을 사용 가능
        IntConsumer intConsumer = (x) -> System.out.println(x);
        intConsumer.accept(10);
        // LongConsumer, DoubleConsumer
        // 주의!: 오버로딩이 아니라, 별도로 만들어 준 것.

        ObjIntConsumer<String> objIntConsumer = (t, x) -> System.out.println(t + ": " + x);
        objIntConsumer.accept("x", 1023);
        // ObjLongConsumer, ObjDoubleConsumer

    }
}
