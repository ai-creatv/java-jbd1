package p01;

import java.util.List;
import java.util.ArrayList;

/**
 * 유닛 테스트 (Unit Test)
 * - 단위 테스트라고도 부르며, 최소 단위의 테스트를 말한다.
 * - 최소 단위: 메소드 단위 (객체 단위)
 *   - 메소드는 객체의 속성을 변화시키는 '부작용(Side-effect)'을 가지고 있기 때문
 *   - 환경 셋업, 환경 정리를 반드시 같이 해 주어야 한다.
 *
 * 통합 테스트 (Integration Test)
 * - 전체 시스템을 동작을 확인하는 테스트
 */


public class ScoreCollection {
    private final List<Scorable> scoreList = new ArrayList<>();

    public void add(Scorable item) {
        scoreList.add(item);
    }

    public int arithmeticMean() {
        int total = scoreList.stream()
                .mapToInt(Scorable::getScore)
                .sum();
        return total / scoreList.size();
    }
}

/**
 * 기존의, 임시적인 테스트 방법
 * - 문제점?
 *   - 여러개의 테스트를 작성하기가 어렵다.
 *   - 여러가지를 테스트할 때 '부작용'이 발생하기 쉽다.
 *     - 실행 순서에 따라 결과가 달라진다.
 *   - 테스트 결과가 성공적인지 파악하기가 어렵다.
 *   - Production 코드와 Test 코드가 섞이게 된다.
 *
 */

class Main {
    public static void main(String[] args) {
        ScoreCollection collection = new ScoreCollection();
        // Test1. 5와 7의 평균은 6
        collection.add(() -> 5);
        collection.add(() -> 7);
        System.out.println(collection.arithmeticMean());

        // Test2. 10과 20의 평균은 15
        // Test1의 영향을 받아서 원하는 테스트 출력을 얻지 못했다.
        // Test1과 Test2의 순서가 달라지면, 또 결과가 달라진다.
        collection = new ScoreCollection(); // 초기화를 추가해서 해결은 가능하다.
        collection.add(() -> 10);
        collection.add(() -> 20);
        System.out.println(collection.arithmeticMean());
    }
}