package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] strings = new String[N];
            for (int j = 0; j < N; j++) {
                strings[j] = bufferedReader.readLine();
            }
            Arrays.sort(strings);
            boolean findAnswer = false;
            for (int j = 0; j < strings.length - 1; j++) {
                if (strings[j].length() > strings[j + 1].length()) {
                    continue;
                }
                if (strings[j].equals(strings[j + 1].substring(0, strings[j].length()))) {
                    findAnswer = true;
                    break;
                }
            }
            if (findAnswer) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        bufferedReader.close();
    }
}
