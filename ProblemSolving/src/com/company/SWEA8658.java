package com.company;

import java.util.Scanner;

public class SWEA8658 { //[Difficulty 3] Summation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] array = new int[N][10];
        int[][] answerArray = new int[N][10];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                while (array[i][j] / 10 != 0) {
                    sum += array[i][j] % 10;
                    array[i][j] /= 10;
                }
                sum += array[i][j];
                answerArray[i][j] = sum;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print("#"+(i+1)+" ");
            int max = answerArray[i][0];
            for (int j = 0; j < 10; j++) {
                if(max < answerArray[i][j]){
                    max = answerArray[i][j];
                }
            }
            System.out.print(max+" ");
            int min = answerArray[i][0];
            for (int j = 0; j < 10; j++) {
                if(min > answerArray[i][j]){
                    min = answerArray[i][j];
                }
            }
            System.out.println(min);
        }
    }
}
