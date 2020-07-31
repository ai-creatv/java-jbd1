package com.company;

/**
 * 배열 (Array)
 * 배열의 특성
 * - 하나의 변수로 여러 개의 값을 다룰 수 있다.
 * - 동일 자료 형만 다룰 수 있다.
 * - 한번 생성한 배열의 크기는 변하지 않는다.
 * - 배열에 속한 값은 메모리에 연속으로 위치한다.
 */

public class Main {

    public static void main(String[] args) {
        int intVal;

        // 배열의 선언
        int [] integers;
//        int cStyleIntegers[];

        long [] longs;
        char [] chars;

        String [] strings;

        // 배열의 생성과 초기화
        integers = new int[10];
        int [] integers2 = new int[10];

        integers2[0] = 5;
        integers2[1] = 10;
        integers2[3] = 9;

        System.out.println(integers2[0]);
        System.out.println(integers2[1]);
        System.out.println(integers2[2]); // 0으로 자동으로 초기화
        System.out.println(integers2[3]);
        // 값을 넣을 때 순차적으로 하지 않아도 된다.
        System.out.println("");

        int [] integers3 = new int[]{5, 2, 3, 6, 12, 4}; // 길이 입력 안해도 된다.
        System.out.println(integers3[0]);
        System.out.println(integers3[1]);
        System.out.println(integers3[2]);
        System.out.println(integers3[3]);
        System.out.println(integers3[4]);
        System.out.println(integers3[5]);
        // System.out.println(integers3[6]); // ArrayIndexOufOfBoundsException 오류 발생
        // 배열 사용할 때에는 선언해 준 길이까지만 접근해야 한다.
        System.out.println("");

        int [] integers5 = {1, 4, 5, 23, 0}; // new int[]를 빼도 초기화 가능

        // 배열을 반복문으로 접근
        float [] floats = new float[5];
        for (int i = 0; i < floats.length; i++) { // for문을 이용한 초기화
            floats[i] = (float)(i * 0.25);
        }

        for (int i = 0; i < floats.length; i++) { // for문을 이용한 출력
            System.out.println(floats[i]);
        }

        // Enhanced for, for each 문이라고도 합니다.
        for (float floatVal: floats) {
            System.out.println(floatVal);
        }
        System.out.println("");

        // 배열의 크기를 변경
        int [] src = {1, 2, 3, 4, 5};
        int [] dst = new int[10];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i];
        }
        for (int integer: dst) {
            System.out.println(integer);
        }

        System.out.println("");
        int [] src2 = {1, 2, 3, 4, 5};
        int [] dst2 = new int[10];
        System.arraycopy(src2, 0, dst2, 0, src2.length);
        for (int integer: dst2) {
            System.out.println(integer);
        }

    }
}
