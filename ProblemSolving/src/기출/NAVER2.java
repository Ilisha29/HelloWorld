package 기출;

import java.util.ArrayList;
import java.util.Scanner;

public class NAVER2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N <= 10) {
            int[] array = new int[11];
            array[0] = 0;
            array[1] = 2;
            array[2] = 6;
            array[3] = 12;
            array[4] = 20;
            array[5] = 24;
            array[6] = 30;
            array[7] = 42;
            array[8] = 56;
            array[9] = 60;
            array[10] = 72;
            System.out.println(array[N]);
        }
        if (N > 10) {
            int num = 10;
            int possibleNumber = 73;
            for (int i = num; i <= N ; i++) {

            }
            }
    }
}
