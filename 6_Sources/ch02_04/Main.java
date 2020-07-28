package com.company;

import java.util.stream.DoubleStream;

/**
 * 연산자 (Operator)
 * 연산자(Operator), 피연산자(Operand) -> 연산식(Expression)
 * 사칙 연산자 + - * /
 * 비교 연산자 > < <= >=
 * 논리 연산자
 * 증감 연산자
 * 삼항 연산자
 * 비트 연산자
 */

public class Main {

    public static void main(String[] args) {
	    // 사칙연산

        int x = 10, y = 20, z;

        z = x + y; // +: 연산자, x: 피연산자, y: 피연산자, x + y: 연산식(Expression)
                   // =: 연산자 z: 피연산자, x + y: 피연산자
        System.out.println(z);

        System.out.println("정수형 사칙 연산");
        System.out.println(20 - 5);
        System.out.println(5 - 20);
        System.out.println(10 * 662);
        System.out.println(150 / 8); // 정수 나누기 -> 몫
        System.out.println(150 % 8); // modulus, 나머지
        System.out.println("");

        System.out.println("실수형 사칙 연산");
        System.out.println(10.0 + 52.3);
        System.out.println(10.5f + 12.3); // float, double이 같이 연산되면 double로 변환 후 연산
        System.out.println(10.4 - 50); // 실수형, 정수형을 같이 연산하면 실수형으로 변환 후 연산
        System.out.println(10.2 * 4.2);
        System.out.println(150 / 8.0); // 실수로 나누면 소수점까지 계산이 이루어짐
        System.out.println(5.2 / 1.2); // 몫이 아니고 실수 값으로 계산 됨
        System.out.println(5.2 % 1.2); // 실수 나눗셈도 modulus 연산으로 나머지 계산 가능
        System.out.println("");

        System.out.println("사칙연산의 주의사항");
        System.out.println(Integer.MAX_VALUE / 2 * 3);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1); // 가장 큰 값에서 overflow 발생 시 가장 작은 값이 됨

        int maxVal = 0b01111111111111111111111111111111;
        int maxVal1= 0b10000000000000000000000000000000;
        System.out.println(maxVal);
        System.out.println(maxVal1);

        // 1's C

        System.out.println((6 - 5.9) * 10);
        System.out.println(Math.floor((6 - 5.9) * 10)); // 정밀도 문제

        System.out.println(40 / 0.0); // Infinity
        System.out.println(40 % 0.0); // NaN
        System.out.println("");

        // 대입 연산자
        z = x + y;
        z += 10; // z = z + 10;
        z %= 2;
        // 논리연산자, 비트연산자 등등 다 됨

        // 비교 연산자
        System.out.println("비교 연산자"); // 출력이 boolean
        System.out.println(10 > 20);
        System.out.println(10 < 20);
        System.out.println(10 >= 10);

        x = 10;
        y = 10;
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println("");

        // 논리연산자 - 입출력이 모두 boolean
        // a AND b : a, b 모두 참일때만 참
        // a OR b : a 또는 b 둘중 하나만 참이어도 참
        // a XOR b : a 또는 b 둘중 하나만 참이어야 참 // exclusive or, 배타적 OR
        // NOT a : a가 참이면 거짓, 거짓이면 참 -> 단항연산자
        System.out.println(10 < 20 & 40 >= 2); // AND
        System.out.println(40 < 2 | 1 > 0); // OR
        System.out.println(!(10 > 20)); // NOT
        System.out.println(10 > 2 ^ 5 > 2); // XOR
        System.out.println("");

        // short-circuit 더 빠르다 나중에 깊게 다뤄드립니다.
        System.out.println(10 < 20 && 4 < 2);
        System.out.println(2 > 8 || 2 < 5);

        // 증감 연산자 - 단항 연산자
        int val = 0;

        System.out.println(val++); // val = 0으로 먼저 Expression 평가 후에 val += 1 적용
        // sout(val);
        // val += 1;
        System.out.println(++val); // va +=1을 먼저 계산한 후에 Expression 평가
        // val += 1;
        // sout(val);
        System.out.println(val--);
        // sout(val);
        // val -= 1;
        System.out.println(--val);
        // val -= 1;
        // sout(val);

        val = 5;
        int new_val = val++ * 10 + --val; // Trash
        System.out.println(new_val);
        System.out.println("");

        // 삼항 연산자
        // (cond)?(true expression):(false expression)
        // boolean    값                    값
        System.out.println(true?1:0);
        System.out.println(false?1:0);

        x = 10;
        y = 13;
        System.out.println(x > y?x:y); // max function
        System.out.println(x < y?x:y); // min function

        // 비트 연산자
        // 정수형 연산에 사용
        System.out.printf("b%32s\n", Integer.toBinaryString(8));
        System.out.printf("b%32s\n", Integer.toBinaryString(8 >> 1)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(7)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(1423)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 2)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 4)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 2)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 4)); // shift 연산자 새로 추가되는 비트는 0

        System.out.printf("b%32s\n", Integer.toBinaryString(-1));
        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >> 1));
        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >>> 1)); // sign비트와 무관하게 0으로 채운다.

        int intVal = 4123;
        intVal >>= 2; // intVal = intVal >> 2;   Shift 연산자도 대입연산자 가능
        intVal |= 412; // intVal = intVal | 412; Bitwise 연산자도 대입연산자 가능

        intVal = 412;
        intVal |= 5523;
        System.out.printf("b%32s\n", Integer.toBinaryString(412));
        System.out.printf("b%32s\n", Integer.toBinaryString(5523));
        System.out.printf("b%32s\n", Integer.toBinaryString(intVal));


//        System.out.printf("b%32s\n", Integer.toBinaryString(1252));
//        System.out.printf("b%32s\n", Integer.toBinaryString(15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 & 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 | 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 ^ 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(~1252)); // 논리 연산자처럼 보이지만 비트연산자이다.
//        System.out.println("");





    }
}
