package com.company;

import java.util.Scanner;

public class BOJ10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[N][2];
        for (int i = 0; i < N ; i++) {
            map[i][0] = scanner.nextInt();
            map[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(map[i][0]+map[i][1]);
        }
    }
}
