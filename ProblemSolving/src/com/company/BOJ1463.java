package com.company;

import java.util.Scanner;
public class BOJ1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] min = new int[1000001];
        min[0]=0;
        min[1]=0;
        int i = 2;
        while(i<=N){
            min[i] = min[i-1] +1;
            if(i%2==0 && min[i/2]+1 <= min[i]) min[i] = min[i/2]+1;
            if(i%3==0 && min[i/3]+1 <= min[i]) min[i] = min[i/3]+1;
            i++;
        }
        System.out.println(min[N]);
    }
}
