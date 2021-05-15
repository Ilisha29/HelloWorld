package BOJ._6DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[][] table = new long[101][10];
        Arrays.fill(table[1], 1);
        table[1][0] = 0;
        for (int i = 2; i < table.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    table[i][j] = table[i - 1][1];
                } else if (j == 9) {
                    table[i][j] = table[i - 1][8];
                } else {
                    table[i][j] = (table[i - 1][j - 1] + table[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += table[N][i];
        }
        System.out.println(sum % 1000000000);
        bufferedReader.close();
    }
}
