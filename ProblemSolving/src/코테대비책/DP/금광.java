package 코테대비책.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] NM = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int[][] map = new int[N][M];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    map[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            for (int j = 1; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    int max;
                    if (k == 0) {
                        int b = map[k][j - 1];
                        int c = map[k + 1][j - 1];
                        max = Math.max(c, b);

                    } else if (k == N - 1) {
                        int a = map[k - 1][j - 1];
                        int b = map[k][j - 1];
                        max = Math.max(a, b);

                    } else {
                        int a = map[k - 1][j - 1];
                        int b = map[k][j - 1];
                        int c = map[k + 1][j - 1];
                        max = Math.max(a, b);
                        max = Math.max(max, c);
                    }
                    map[k][j] += max;
                }
            }
            int answer = 0;
            for (int j = 0; j < N; j++) {
                answer = map[j][M - 1] > answer ? map[j][M - 1] : answer;
            }
            System.out.println(answer);
        }
        bufferedReader.close();
    }
}
