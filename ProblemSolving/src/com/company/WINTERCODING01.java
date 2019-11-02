package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;

public class WINTERCODING01 { //문제 이해 10분 / 구현 1시간 20분;;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            int[] answer = {0};
        } else if (n == 2) {
            int[] answer = {0, 0, 1};
        } else if (n == 3) {
            int[] answer = {0, 0, 1, 0, 0, 1, 1};
        } else {
            double size = Math.pow(2, n) - 1;

            int[] prevArray = new int[(int) size];
            prevArray[0] = 0;
            prevArray[1] = 0;
            prevArray[2] = 1;
            prevArray[3] = 0;
            prevArray[4] = 0;
            prevArray[5] = 1;
            prevArray[6] = 1;

            int[] answer = new int[(int) size];
            answer[0] = 0;
            answer[1] = 0;
            answer[2] = 1;
            answer[3] = 0;
            answer[4] = 0;
            answer[5] = 1;
            answer[6] = 1;

            for (int k = 4; k <= n; k++) {
                for (int j = 0; j < Math.pow(2, k - 1); j++) {
                    answer[j] = prevArray[j];
                    if (prevArray[j] == 0) {
                        answer[((int) Math.pow(2, k)) - 2 - j] = 1;
                    }
                    if (prevArray[j] == 1) {
                        answer[((int) Math.pow(2, k)) - 2 - j] = 0;
                    }
                }
                answer[((int) Math.pow(2, k) -1) / 2] = 0;
                for (int j = 0; j < Math.pow(2, k) - 1; j++) {
                    prevArray[j] = answer[j];
                }
            }
            for (int i = 0; i < size ; i++) {
                System.out.print(answer[i]);
            }
        }
    }
}
