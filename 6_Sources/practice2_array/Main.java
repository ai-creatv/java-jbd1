package com.company;

/**
 * Array 연습
 *
 */

public class Main {

    public static void main(String[] args) {
	    int [] integers = {4, 2, 12 , 23, 62 , 9, -2, 0, -4};
	    // 1. 위 배열에서 최대값을 찾는 프로그램을 작성하시오.
        int maxVal = integers[0];
        for (int i = 0; i < integers.length; i++) {
            if (maxVal < integers[i]) {
                maxVal = integers[i];
            }
        }
        System.out.println(maxVal);

        maxVal = integers[0];
        for (int val: integers) {
            maxVal = maxVal > val ? maxVal : val;
        }
        System.out.println(maxVal);

        // 2. 위 배열에서 2번째로 큰 값을 찾는 프로그램을 작성하시오.
        int [] maxVals = new int[2];
        maxVals[0] = integers[0] > integers[1] ? integers[0] : integers[1];
        maxVals[1] = integers[0] < integers[1] ? integers[0] : integers[1];
        for (int val: integers) {
            if (maxVals[0] < val) {
                maxVals[1] = maxVals[0];
                maxVals[0] = val;
            } else if(maxVals[1] < val) {
                maxVals[1] = val;
            }
        }
        System.out.println(maxVals[1]);

    }
}
