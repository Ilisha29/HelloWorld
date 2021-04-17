package BOJ;

import java.util.Scanner;

public class BOJ1100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chess = new char[8][8];
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8 ; j++) {
               // chess[i][j] = scanner.next();
            }
        }

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8 ; j++) {
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }
}
