package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOj1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        int[] alphabets = new int[26];
        for (int i = 0; i < rep; i++) {
            String[] strings = bufferedReader.readLine().split("");
            int len = strings.length;
            for (int j = 0; j < len; j++) {
                alphabets[strings[j].charAt(0) - 'A'] += (int) Math.pow(10, len - 1 - j);
            }
        }
        Arrays.sort(alphabets);
        int multi = 9;
        int sum = 0;
        for (int i = alphabets.length - 1; i >= alphabets.length - 9; i--) {
            sum += alphabets[i] * multi;
            multi--;
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
