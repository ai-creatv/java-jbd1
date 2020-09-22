package ch5.s05.p03;

/**
 * 다양한 람다식의 표현 형식
 */

@FunctionalInterface
interface Runner {
    String run(String x);
}

@FunctionalInterface
interface RunnerTwo {
    String run();
}

public class Main {
    static void useRunner(String x, Runner runner) {
        System.out.println(runner.run(x));
    }

    static void useRunnerTwo(RunnerTwo runner) {
        System.out.println(runner.run());
    }

    public static void main(String[] args) {
        useRunner("안녕", (String x) -> { return x;}); // 입력 파라미터의 자료형 입력 가능
        useRunner("안녕", x -> { return x;}); // 입력 파라미터가 1개면 () 생략 가능
        useRunnerTwo(() -> { return "안녕";}); // 입력 파라미터가 없으면 () 생략 불가
        useRunner("안녕", (x) -> {
            return x; // 세미콜론이 들어가는 경우(여러 줄 작성) 중괄호 필수. 이 때 return도 필요함
        });
        useRunner("안녕", x -> x); // Expression을 바로 쓰면 알아서 return을 해 줌 (expression lambda)
    }
}
