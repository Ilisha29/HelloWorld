package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        int result = 0;

        while (rep-- > 0) {
            String string = bufferedReader.readLine().trim();
            if (okGroup(string)) result++;
        }
        System.out.println(result);
    }

    private static boolean okGroup(String string) {
        boolean[] alpabet = new boolean[26];
        int length = string.length();
        int i;
        for (i = 0; i < length; i++) {
            char temp = string.charAt(i);
            if (alpabet[temp - 'a']) {
                return false;
            } else {
                if (i < length - 1 && temp != string.charAt(i + 1)) {
                    alpabet[temp - 'a'] = true;
                }
            }
        }
        return true;
    }
}

