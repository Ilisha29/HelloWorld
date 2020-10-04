package 코테대비책.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
*/

public class 정확한순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int rep = Integer.parseInt(stringTokenizer.nextToken());
        int[][] adjMatrix = new int[N + 1][N + 1];
        for (int i = 0; i < rep; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            adjMatrix[from][to] = 1;
        }

        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] == 0 && i != j) {
                    adjMatrix[i][j] = 1000000000;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adjMatrix[i][j] == 1000000000) {
                    System.out.print("X ");
                } else
                    System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        //거쳐가는것
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    adjMatrix[j][k] = Math.min(adjMatrix[j][k], adjMatrix[j][i] + adjMatrix[i][k]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adjMatrix[i][j] == 1000000000) {
                    adjMatrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (adjMatrix[i][j] != 0 || adjMatrix[j][i] != 0) {
                    count++;
                }
            }
            if (count == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
        bufferedReader.close();
    }
}
