package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10989 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
