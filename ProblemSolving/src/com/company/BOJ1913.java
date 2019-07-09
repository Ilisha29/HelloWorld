package com.company;

import java.util.Scanner;

public class BOJ1913 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int FindNum = scanner.nextInt();
        //실패 19.07.09
        /*
        int[] dirctionIndex = new int[N*2];
        int[][] realMap = new int[N][N];
        int[][] indexMap = new int[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                indexMap[i][j]=0;
            }
        }
        int Num = N;
        dirctionIndex[0] = N;
        for (int i = 1; i < dirctionIndex.length ; i++) {
            dirctionIndex[i] = N;
            if(i%2 != 0){
                N--;
            }
        }

        int startNum = N*N;
        int i = 0;
        int j = 0;
        int direction = 1;
        int x = 1;
        int index = dirctionIndex[x];
        for (int k = 0; k < N*N; k++) {
            realMap[i][j] = startNum--;
            index--;
            if(index != 0 && direction == 1){
                j++;
            }
            if(index != 0 && direction == 2){
                i++;

            }
            if(index != 0 && direction == 3){
                j--;

            }
            if(index != 0 && direction == 4){
                i++;
            }
            if(index == 0 ){
                if(direction ==1){
                    direction=2;
                    i++;
                }
                if(direction ==2){
                    direction=3;
                    j--;
                }
                if(direction ==3){
                    direction=4;
                    i--;
                }
                if(direction ==4){
                    direction=1;
                    j++;
                }
                index = dirctionIndex[++x];
            }
        }
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                System.out.print(realMap[k][j]+" ");
            }
            System.out.println();
        }
        */
    }
}
