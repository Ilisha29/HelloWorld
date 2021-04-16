package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[15][15];
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < 15; i++) {
            map[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                int sum = 0;
                for (int k = 1; k <= j; k++) {
                    sum += map[i - 1][k];
                }
                map[i][j] = sum;
            }
        }
        for (int i = 0; i < rep; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());
            System.out.println(map[k][n]);
        }
        bufferedReader.close();
    }
}
