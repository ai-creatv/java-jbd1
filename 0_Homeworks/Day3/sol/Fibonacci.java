import java.math.BigInteger;

/**
 * 피보나치 수열
 *
 * 피보나치 수열을 출력하는 프로그램을 작성하시오.
 *
 * 피보나치 수열의 점화식 : f(n) = f(n-1) + f(n-2)
 *                        f(1) = 0, f(2) = 1 
 *
 * 0, 1, 1, 2, 3, 5, 8, ...
 *
 * 인자
 * seqLength: 출력하고자 하는 피보나치 수열의 길이
 */

public class Fibonacci {
    public static void main(String[] args) {
        int seqLength = 100;
        BigInteger valOne =  BigInteger.ZERO;
        BigInteger valTwo =  BigInteger.ONE;
        for (int i = 0; i < seqLength; i++) {
            System.out.printf("%d ", valOne);
            BigInteger valThree = valOne.add(valTwo);
            valOne = valTwo;
            valTwo = valThree;
        }
    }
}