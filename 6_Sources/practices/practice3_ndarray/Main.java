package com.company;

/**
 * N-D Array 연습
 */

public class Main {

    public static void main(String[] args) {
	    int [][] matA = {{1,2,3}, {3,4,5}}; // 2x3
	    int [][] matB = {{3,4,5}, {1,4,2}}; // 2x3

	    // 1. matA + matB 를 구하고, 출력하시오.
        int [][] matC = new int[matA.length][matA[0].length];
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[i].length; j++) {
                matC[i][j] = matA[i][j] + matB[i][j];
            }
        }

        for (int [] row: matC) {
            for (int elem: row) {
                System.out.printf("%d ", elem);
            }
            System.out.println("");
        }

        // 2. matA를 Transpose하고 출력하시오.
        int [][] matA_ = new int[matA[0].length][matA.length];
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[0].length; j++) {
                matA_[j][i] = matA[i][j];
            }
        }

        for (int [] array: matA_) {
            for (int val: array) {
                System.out.printf("%d ", val);
            }
            System.out.println("");
        }

        // 1 2 3
        // 4 5 6

        // 1 4
        // 2 5
        // 3 6
    }
}
