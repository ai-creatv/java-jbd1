package com.company;

/**
 * 조건문 - 조건에 따라서 코드의 실행 흐름을 결정
 * if 계열
 * switch 계열
 *
 * [branch 문] - 기계어 수준에서 부르는 조건 실행문
 */

public class Main {

    public static void main(String[] args) {
        String snum = "510225-2055132";
        char c = snum.charAt(7);
        System.out.println(c);

        if (c == '1') {
            System.out.println("남자입니다.");
        }

        if (c == '1' || c == '3') {
            System.out.println("남자입니다.");
        } else {
            System.out.println("여자입니다.");
        }

        int x = 6;
        if (x % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
        System.out.println(x % 2 == 0 ? "짝수입니다." : "홀수입니다.");
        System.out.println("");

        int score = 2;
        char grade;
        if (score >= 9) {
            grade = 'A';
        } else if (score >= 7) {
            grade = 'B';
        } else if (score >= 5) {
            grade = 'C';
        } else if (score >= 3) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println(grade);

        score = 90;
        boolean isLate = true;
        // late인 경우에는 하나 낮은 그레이드를 주기로 하였다.
        // Nested if 문
        if (score >= 90) {
            if (isLate) {
                grade = 'B';
            } else {
                grade = 'A';
            }
        } else if (score >= 80) {
            if (isLate) {
                grade = 'C';
            } else {
                grade = 'B';
            }
        } else if (score >= 70) {
            if (isLate) {
                grade = 'D';
            } else {
                grade = 'C';
            }
        } else if (score >= 60) {
            if (isLate) {
                grade = 'F';
            } else {
                grade = 'D';
            }
        } else {
            grade = 'F';
        }
        System.out.println("");

        grade = 'A';
        // switch ~ case 문의 조건문은 '값'이 들어오게 된다. (boolean에 한정되지 않습니다.)
        // case가 범위가 될 수 없고, case도 값이어야 합니다.
        switch (grade) {
            case 'A':
                System.out.println("훌륭합니다!"); // fall-through
            case 'B':
                System.out.println("멋집니다!");
                break;
            case 'C':
            case 'D':
                System.out.println("많이 노력하세요!");
                break; // break가 없으면 fall-through가 발생함
            default:
                System.out.println("다음엔 잘하세요.");
        }

    }
}
