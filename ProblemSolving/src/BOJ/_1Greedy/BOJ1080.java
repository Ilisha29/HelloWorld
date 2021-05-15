package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;
        int[][][] matrix = new int[2][N][M];
        while (count < 2) {
            int row = 0;
            while (row < N) {
                String[] rowNum = bufferedReader.readLine().split("");
                for (int i = 0; i < M; i++) {
                    matrix[count][row][i] = Integer.parseInt(rowNum[i]);
                }
                row++;
            }
            count++;
        }
        if (N < 3 || M < 3) {
            int beforeSum = 0;
            int afterSum = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (i == 0) {
                            beforeSum += matrix[i][j][k];
                        } else {
                            afterSum += matrix[i][j][k];
                        }
                    }
                }
            }
            if (beforeSum == afterSum) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        } else {
            int changeCount = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (matrix[0][i][j] != matrix[1][i][j]) {
                        changeCount++;
                        for (int k = i; k < i + 3; k++) {
                            for (int l = j; l < j + 3; l++) {
                                matrix[1][k][l] = (matrix[1][k][l] == 1) ? 0 : 1;
                            }
                        }
                    }
                }
            }
            boolean equalFlag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[0][i][j] != matrix[1][i][j]) {
                        equalFlag = false;
                        break;
                    }
                }
            }
            if (equalFlag) {
                System.out.println(changeCount);
            } else {
                System.out.println(-1);
            }
        }
        bufferedReader.close();
    }
}
