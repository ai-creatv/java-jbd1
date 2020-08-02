package com.company;

/**
 * 반복문 (Loops)
 * for 문, while 문
 * 초기화 - 반복문을 실행하기 위해서 증감할 변수를 초기화
 * 조건식 - 반복문을 실행할 조건 (또는 종료할 조건)
 * 실행문 - 조건식이 참(또는 거짓)일 경우 실행할 코드
 * 증감식 - 실행문이 실행된 후에 변수에 증감을 주는 것
 */
public class Main {
    public static void main(String[] args) {
        // for 문
             //초기화   ; 조건식 ; 증감식
        for (int i = 0; i < 5; i++) {
            System.out.println(i); // 실행문
        }
        System.out.println("");

        for (int i = 0; i < 5; i += 2) {
            System.out.println(i);
        }
        System.out.println("");

        for (int i = 4; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("");

        // nested for
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("(%d, %d)\n", i, j);
            }
        } // 5*5 = 25

        for (int i = 0; i < 5; i++)
            System.out.print(i); // iterated
        System.out.println(""); // not iterated

        // while 문
        // 초기화
        // while (조건문) {
        //    실행문
        //    증감식
        // }
//
//        int i = 0;
//        while (i < 5) {
//            System.out.println(i);
//            i++;
//        }

//        i = 0;
//        do {
//            System.out.println(i);
//            i++;
//        } while(false); // 조건문이 false여도 반드시 한번 실행된다.

        // 제어문 - break continue
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }

        loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                if (i == 3 && j == 2) {
                    System.out.println("continue called");
                    continue loop1;
                }
            }
        }

    }
}
