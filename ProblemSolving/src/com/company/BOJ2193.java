package com.company;

import java.util.Scanner;

public class BOJ2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //배열 접근에 주의!!!! N값이 1이거나 2일때 주의하기!
        if (N == 1) {
            System.out.println(1);
        }
        if (N == 2) {
            System.out.println(1);
        }
        if (N >= 3) {
            long[] array = new long[N];
            array[0] = 1;
            array[1] = 1;
            int i = 2;
            while (i <= N - 1) {
                array[i] = array[i - 1] + array[i - 2];
                i++;
            }
            System.out.print(array[N - 1]);
        }
    }
}
