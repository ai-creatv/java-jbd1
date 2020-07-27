package com.company;

/**
 * 자료형 (Data Type)
 * 자료형 - 기본형 (Primitive Type), 참조형 (Reference Type)
 * 기본형 자료형 - 정수형, 실수형, 문자형, 논리형
 * 참조형 자료형 - 문자열 (String)
 */

public class Main {

    public static void main(String[] args) {
        //정수형 : byte, short, int, long
        System.out.println("Byte");
        System.out.println(Byte.BYTES);
        byte byteValue = 42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE); // 2^7 - 1
        System.out.println(Byte.MIN_VALUE); // -2^7
        // byte byteValue1 = 128;
        System.out.println("");

        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE); // 2^15 - 1
        System.out.println(Short.MIN_VALUE); // -2^15
        System.out.println("");

        System.out.println("Int");
        System.out.println(Integer.BYTES); // 4
        System.out.println(Integer.MAX_VALUE); // 2^31 - 1
        System.out.println(Integer.MIN_VALUE); // -2^31
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES); // 8
        System.out.println(Long.MAX_VALUE); // 2^63 - 1
        System.out.println(Long.MIN_VALUE); // -2^63
        System.out.println("");

        // Overflow
        // 32767 = 2^15 - 1 => 0111111111111111
        short shortValue = (short)64000;
        System.out.println(shortValue);
        System.out.println("");

        // 정수형은 기본적으로 int
        //byte byteValue3 = 144;
        short shortA = 10;
        short shortB = 20;
        short shortC = (short)(shortA + shortB);

        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt + 1; // overflow 주의
        System.out.println(biggerInt);

        long veryBigInt = 10000000000000L;
        System.out.println(veryBigInt);

        // 진수법 - Binary(2), Octal(8), Decimal(10), Hexadecimal(16)
        System.out.println(0b1101);
        System.out.println(071);
        System.out.println(1424);
        System.out.println(0x10); // 0~9 10~15: a,b,c,d,e,f
        System.out.println(0xff);

        byte flagByte = 0b00101100;




    }
}
