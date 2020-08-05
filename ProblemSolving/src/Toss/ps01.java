package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ps01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        if (isNotAllOneTwo(string)) {
            System.out.print("false");
        } else {
            String[] strings = string.split("");
            if (strings[strings.length - 1].equals("1")) {
                System.out.print("false");
            } else if (string.contains("11")) {
                System.out.print("false");
            } else {
                System.out.print("true");
            }
        }
        bufferedReader.close();
    }

    private static boolean isNotAllOneTwo(String string) {
        String[] strings = string.split("");
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("1") && !strings[i].equals("2")) {
                return true;
            }
        }
        return false;
    }
}
