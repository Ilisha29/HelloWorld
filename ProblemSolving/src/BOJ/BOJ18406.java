package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split("");
        int left = 0;
        int right = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i < (strings.length / 2)) {
                left += Integer.parseInt(strings[i]);
            } else {
                right += Integer.parseInt(strings[i]);
            }
        }
        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
        bufferedReader.close();
    }
}
