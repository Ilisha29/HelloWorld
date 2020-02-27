package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int rep = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[row][col];
        boolean[][] check = new boolean[row][col];
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            int row1 = Integer.parseInt(stringTokenizer1.nextToken());
            int col1 = Integer.parseInt(stringTokenizer1.nextToken());
            int row2 = Integer.parseInt(stringTokenizer1.nextToken());
            int col2 = Integer.parseInt(stringTokenizer1.nextToken());
            for (int j = row1; j < row2; j++) {
                for (int k = col1; k < col2; k++) {
                    check[j][k] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        bufferedReader.close();
    }
}
