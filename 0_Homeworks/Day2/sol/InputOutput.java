import java.util.Scanner;

/**
 * 입력받아 처리하기
 *
 * 3개의 정수를 입력받아, 그 중 최대값을 출력하고자 한다.
 * 이를 수행하는 프로그램을 작성하시오.
 *
 */

public class InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input integer (1/3): ");
        int valOne = scanner.nextInt();
        System.out.print("Input integer (2/3): ");
        int valTwo = scanner.nextInt();
        System.out.print("Input integer (3/3): ");
        int valThree = scanner.nextInt();

        int valMax = valOne > valTwo ? valOne : valTwo;
        valMax = valMax > valThree ? valMax : valThree;

        System.out.print("Maximum value:");
        System.out.println(valMax);
        scanner.close();
    }
}