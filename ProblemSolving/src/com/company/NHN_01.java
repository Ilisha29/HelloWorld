package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NHN_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <String> arrayList = new ArrayList<>();
        int cardNo = scanner.nextInt();

        for (int i = 0; i < cardNo; i++) {
            arrayList.add(scanner.next());
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        ArrayList<Integer> card= new ArrayList<>();
        card.add(1);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i).equals(arrayList.get(i-1))){

            }
        }
    }
}
