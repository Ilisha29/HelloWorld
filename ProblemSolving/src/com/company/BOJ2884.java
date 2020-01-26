package com.company;

import java.util.Scanner;

public class BOJ2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int HH = scanner.nextInt();
        int MM = scanner.nextInt();
        if (MM < 45) {
            if (HH == 0) {
                System.out.println("23 "+(MM+15));
            } else {
                System.out.println((HH-1)+" "+(MM+15));
            }
        } else {
            System.out.println(HH + " " + (MM - 45));
        }
    }
    //회고 : 대충읽었을때는 좀 복잡해보였는데, 좀 간단하게 생각하다보니 생각보다 손쉽게 해결되었다.
}
