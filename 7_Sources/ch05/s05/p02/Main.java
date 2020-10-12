package ch5.s05.p02;

/**
 * 람다식을 사용하기 위한 조건
 */

@FunctionalInterface // 필수는 아니다. 하지만 적어주면 interface가 적합한지 확인
interface Runner<T> {
    T run(); // 단 하나의 abstract method.
    //T runTwo(); // abstract method가 2개 이상이면 오류 발생
    default void method() {} // default 메소드는 상관이 없다.
}

public class Main {
    static void useRunner(Runner<?> runner) {
        System.out.println(runner.run());
    }

    public static void main(String[] args) {
        useRunner(() -> "This is how to use runner.");
    }
}
