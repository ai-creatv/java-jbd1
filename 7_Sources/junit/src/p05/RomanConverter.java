package p05;

// I -> 1
// II -> 2
// III -> 3
// IV -> 4 ...

/**
 * TDD, 테스트 주도 개발 (Test-Driven Development)
 * - '실패하는' 테스트 케이스를 먼저 작성하고,
 * - 이것을 통과시키는 방식으로 코드를 구현하는 방식
 * - 테스트 케이스 작성 -> 코드 구현 -> (커밋) -> (리팩토링) -> 테스트 케이스 작성 .. 을 빠르게 반복
 *   - 1~2분 간격으로 매우 빠른 호흡으로 진행
 *
 * - 도메인 지식이 없어도 테스트 케이스를 작성할 수 있다.
 */

public class RomanConverter {
    private String roman = "";

    public void setRoman(String roman) {
        this.roman = roman;
    }

    public int transform() {
        if (roman.equals("")) {
            throw new ArithmeticException();
        }

        if (roman.contains("X")) {
            return 10;
        }
        int count = 0;
        boolean beforeV = roman.contains("V");
        for(char c: roman.toCharArray()) {
            if (c == 'I') {
                count += beforeV ? -1 : 1;
            }
            if (c == 'V') {
                beforeV = false;
                count += 5;
            }
        }

        return count;

    }
}
