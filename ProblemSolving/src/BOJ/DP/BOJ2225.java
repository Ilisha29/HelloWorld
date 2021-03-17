package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i <= N; i++) {
            matrix[1][i] = 1;
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = (matrix[i - 1][j] + matrix[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(matrix[K][N]);
        bufferedReader.close();
    }
}
