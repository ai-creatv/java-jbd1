package com.company;

/**
 * 반복문/조건문 연습
 */

/**
 * **********
 * **********
 * **********
 * **********
 */



/**
 * *
 * **
 * ***
 * ****
 * *****
 */

/**
 *     *
 *    **
 *   ***
 *  ****
 * *****
 */

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println("");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i;j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(i+1);
            }
            System.out.println("");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i;j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(j - i > 0 ? j - i + 1 : i - j + 1);
            }
            System.out.println("");

        }
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 1; j--) {
                if (j <= i + 1) {
                    System.out.print(j);
                } else {
                    System.out.print(' ');
                }
            }
            for (int j = 1; j <= 5; j++) {
                if (j <= i + 1) {
                    System.out.print(j);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }

        /**
         * 369 게임
         * 기본형 (순서대로 다 출력, 짝! 하는거는 3, 6, 9 나오면 한번만)
         * 1부터 시작해서 10
         */
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println("짝!");
            } else {
                System.out.println(i);
            }
        }

        /**
         * 순서대로 다 출력, 1 ~ 30
         */

        for (int i = 1; i <= 30; i++) {
            int num1 = i % 10;
            int num2 = i / 10;

            if (num1 == 3 || num1 == 6 || num1 == 9 ||
                num2 == 3 || num2 == 6 || num2 == 9) {
                System.out.println("짝!");
            } else {
                System.out.println(i);
            }
        }

        /**
         * 369
         * 5명 같이하고, 내가 1번
         * 3,6,9가 여러개 있으면 해당 횟수만큼 짝!
         * 1 ~ 60
         */
        System.out.println("");
        for (int i = 1; i <= 60; i += 5) {
            int num1 = i % 10;
            int num2 = i / 10;
            int numClap = 0;
            if (num1 == 3 || num1 == 6 || num1 == 9) {
                numClap++;
            }
            if (num2 == 3 || num2 == 6 || num2 == 9) {
                numClap++;
            }
            if (numClap == 0) {
                System.out.println(i);
            } else {
                for (int j = 0; j < numClap; j++) {
                    System.out.print("짝");
                }
                System.out.println("");
            }
        }

        /**
         * 369 게임
         * 내가 1번, 8명이 같이 합니다.
         * 짝 을 여러번 해요
         * 10의 배수에서는 다같이 만세!를 외칩니다.
         * 1 ~ 99
         */
        for (int i = 1; i <= 99; i++) {
            int num1 = i % 10;
            int num2 = i / 10;
            int numClap = 0;

            if (i % 10 == 0) {
                System.out.println("만세!");
                continue;
            }

            if ((i - 1) % 8 != 0) {
                continue;
            }

            if (num1 == 3 || num1 == 6 || num1 == 9) {
                numClap++;
            }
            if (num2 == 3 || num2 == 6 || num2 == 9) {
                numClap++;
            }
            if (numClap == 0) {
                System.out.println(i);
            } else {
                for (int j = 0; j < numClap; j++) {
                    System.out.print("짝");
                }
                System.out.println("");
            }
        }



    }
}
