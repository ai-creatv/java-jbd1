import java.util.Scanner;

/**
 * 환자 레코드 출력하기
 * 
 * 환자 레코드를 열전사 프린터로 보기좋게 프린트하려 한다.
 * 환자의 ID, 환자의 병명, 그리고 비고 사항을 입력받아
 * 포맷에 맞게 출력하는 프로그램을 작성하시오.
 * 
 * 제한 사항
 * - 환자의 ID는 1 이상 999999 이하의 정수로 입력된다고 가정한다.
 * - 환자의 병명은 5자 이하의 문자열로 입력되며, 좌측 정렬하여 출력한다.
 * - 비고 사항은 10자 이하의 문자열로 입력되며, 좌측 정렬하여 출력한다.
 * 
 * 출력 포맷
 * *----------*--------*---------------*
 * | ID004029 | 코로나19 | 자가 격리 조치   |
 * *----------*--------*---------------*
 * 
 */


public class PrintFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int id = scanner.nextInt();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        // write codes here
        
    }
}