package com.company;

import java.util.Scanner;

public class KAKAO2020BLIND_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int stringLength = string.length();
        int bestSolution = stringLength;
        int halfLength = stringLength / 2;
        int sum = 0;
        int sameNum = 0;
        System.out.println();
        for (int i = 1; i <= halfLength; i++) {
            String indexString = string.substring(0,i);
            System.out.println(indexString+"\n"+"========");
            for (int j = 0; j < string.length()-i; j += i) {
                if (indexString.equals(string.substring(j, j + i))) {
                    System.out.println(indexString.equals(string.substring(j, j + i)));
                    sameNum++;
                    System.out.println((j+1)+"번쨰 반복문의 sameNumr값 =>"+sameNum);
                }

                else {
                    System.out.println(sameNum);
                    System.out.println(false);
                    if(sameNum == 1){
                        sum+=i;
                    }
                    else{
                        sum += (i+1);
                        System.out.println("sameNum이 1이 아닐때의 sum값"+sum);
                    }
                    indexString = string.substring(j, j + i);
                    sameNum = 1;
                }
            }
            System.out.println(i+"단위로 끊었을때 길이 ==> "+sum);
            if (sum < bestSolution) {
                bestSolution = sum;
            }
            sum =0;
            sameNum = 0;
        }
        System.out.println(bestSolution);
    }
}
