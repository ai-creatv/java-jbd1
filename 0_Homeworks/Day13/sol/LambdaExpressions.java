/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 *
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 *
 */

interface Solution<T, R> {
    R solve(T t);
}

class Algorithm<T, R> {
    boolean test(T input, R groundtruth, Solution<? super T, ? super R> solution) {
        return solution.solve(input).equals(groundtruth);
    }
}

class AlgoInput {
    int x, y, z;

    public AlgoInput(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {
        Algorithm<AlgoInput, Integer> algo = new Algorithm<>();
        System.out.println(algo.test(new AlgoInput(1, 2, 3),6,
                input -> input.x + input.y + input.z));
    }
}
