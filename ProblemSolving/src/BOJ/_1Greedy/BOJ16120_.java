package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16120_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("");
        System.out.println(printAnswer(input));
        bufferedReader.close();
    }

    private static String printAnswer(String[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("P")) {
                count++;
                continue;
            }
            if (count >= 2 && i + 1 < input.length &&input[i + 1].equals("P")) {
                count--;
                i++;
            } else {
                return "NP";
            }
        }
        if (count == 1) {
            return "PPAP";
        } else {
            return "NP";
        }
    }
}
