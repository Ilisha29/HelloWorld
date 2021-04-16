package BOJ;

import java.util.Scanner;

public class BOJ11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int startNum = 0;
        int maxNum = 1;
        for (int i = 0; i < N; i++) {
            maxNum *= 10;
        }
        while (startNum < maxNum) {

        }
        System.out.println(maxNum);
    }
}
