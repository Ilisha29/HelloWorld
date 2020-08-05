package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ps02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        if (strings.length != 6) {
            System.out.println("false");
        } else if (!conditionFirst(strings)) {
            System.out.println("false");
        } else if (!conditionSecond(strings)) {
            System.out.println("false");
        } else if (!conditionThird(strings)) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
        bufferedReader.close();
    }

    private static boolean conditionThird(String[] strings) {
        int tmp = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            int num = Integer.parseInt(strings[i]);
            if (tmp > num) {
                return false;
            } else {
                tmp = num;
            }
        }
        return true;
    }

    private static boolean conditionSecond(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            int num = Integer.parseInt(strings[i]);
            if (!(num >= 1 && num <= 45)) {
                return false;
            }
        }
        return true;
    }

    private static boolean conditionFirst(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
