package 코테대비책.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split("");
        int[] alphabets = new int[26];
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            char c = strings[i].charAt(0);
            if ('A' <= c && c <= 'Z') {
                alphabets[c - 'A']++;
            } else {
                sum += c - '0';
            }
        }
        for (int i = 0; i < alphabets.length; i++) {
            for (int j = 0; j < alphabets[i]; j++) {
                System.out.print((char) (i + 'A'));
            }
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}

