package Programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Programmers스킬체크테스트Level1_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> tmpArrayList = new ArrayList<>();
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            arrayList.add(i);
        }
        while (arrayList.size() != 0) {
            int N = arrayList.get(0);
            answer++;
            arrayList.remove(0);
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) % N != 0) {
                    tmpArrayList.add(arrayList.get(i));
                }
            }
            arrayList.clear();
            for (int i = 0; i < tmpArrayList.size(); i++) {
                arrayList.add(tmpArrayList.get(i));
            }
            tmpArrayList.clear();
        }
        System.out.println(answer);
    }
}
