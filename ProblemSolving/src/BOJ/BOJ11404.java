package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] adjMatrix = new int[N + 1][N + 1];
        int[][] floyd = new int[N + 1][N + 1];
        int input = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < input; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            int from = Integer.parseInt(strings[0]);
            int to = Integer.parseInt(strings[1]);
            int price = Integer.parseInt(strings[2]);
            if (adjMatrix[from][to] != 0) {
                adjMatrix[from][to] = Math.min(adjMatrix[from][to], price);
            } else {
                adjMatrix[from][to] = price;
            }

        }

        for (int i = 1; i < floyd.length; i++) {
            for (int j = 1; j < floyd.length; j++) {
                if (adjMatrix[i][j] == 0 && i != j) {
                    adjMatrix[i][j] = 1000000000;
                }
            }
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
        bufferedReader.close();
    }
}
