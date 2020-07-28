package com.company;

import java.util.Scanner;

/**
 * 자료 입출력
 * 출력 - print println printf , 포맷팅 방법
 * 입력 - 키보드 입력 받기
 */

public class Main {

    public static void main(String[] args) {
//        // 출력 메소드
//        System.out.println("String can be printed.");
//        System.out.println('C');
//        System.out.println(40234);
//        System.out.println(1.52f);
//        System.out.println(15.2434);
//
//        System.out.print("124124\n");
//        System.out.println("");
//
//        System.out.printf("%s is for string\n", "STRING");
//        System.out.printf("%s%s%s\n", "123", "1423", "15234");
//        System.out.printf("%b\n", true);
//        System.out.printf("%d 0x%x 0X%X 0%o\n", 15, 15, 15, 15);
//        System.out.printf("%f\n", 14.23);
//        System.out.printf("%f\n", 14.23f);
//        System.out.printf("%e\n", 14.423);
//        System.out.printf("%c %c\n", 'U', '\u0042');
//        System.out.printf("%n");
//
//        // 정수 포맷팅
//        System.out.printf("%5dasdf\n", 10);
//        System.out.printf("%-5dasdf\n", 10);
//        System.out.printf("%05d\n", 234);
//        System.out.printf("%3d\n", 104294); // 3칸은 최소한 확보, 실제 출력은 다 한다.
//        System.out.println("");
//
//        // 실수 자릿수 표현
//        System.out.printf("%5.4f\n", 152523.456228);
//        System.out.printf("%5.2fasdf\n", 1.425);
//        System.out.printf("%-5.2fasdf\n", 1.425);
//        System.out.println("")

        // 입력 메소드
        System.out.println("Input methods.");
        Scanner scanner = new Scanner(System.in);

        // this is string
        // 공백으로 구분되는 문자열
        // next() 메소드는 입력을 내용이 있을 때 까지 기다립니다.
        // Blocking 메소드라고 부른다. (<-> non-blocking 메소드)
//        System.out.println(scanner.next()); // "this"
//        System.out.println(scanner.next()); // "is"
//        System.out.println(scanner.next()); // "string"

        // 공백으로 구분되는 정수
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextInt()); // 자료형 안맞으면 에러 발생

        // \n으로 구분이 되는 String을 입력 받는다.
        // 키보드에서는 엔터
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());

    }
}
