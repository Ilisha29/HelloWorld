package com.company;

import java.util.Scanner;

public class BOJ2588 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int firstM = m / 100;
        int midM = (m % 100) / 10;
        int lastM = m % 10;

        System.out.println(n * lastM);
        System.out.println(n * midM);
        System.out.println(n * firstM);
        System.out.println(n * firstM * 100 + n * midM * 10 + n * lastM);
    }
}
