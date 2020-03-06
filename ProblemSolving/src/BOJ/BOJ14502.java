package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14502 {
    //1. 벽세우기
    //2. 감염시키기
    //3. 안전공간 세기
    static int[][] map;
    static int[][] tmpMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        tmpMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        int answer = 0;
        //벽세우기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    for (int l = 0; l < col; l++) {
                        for (int m = 0; m < row; m++) {
                            for (int n = 0; n < col; n++) {
                                if (!(i == k && j == l) && !(i == m && j == n) && !(k == m && l == n)) {
                                    if (map[i][j] == 0 && map[k][l] == 0 && map[m][n] == 0) {
                                        boolean[][] check = new boolean[row][col];
                                        for (int o = 0; o < row; o++) {
                                            for (int p = 0; p < col; p++) {
                                                tmpMap[o][p] = map[o][p];
                                            }
                                        }
                                        tmpMap[i][j] = 1;
                                        tmpMap[k][l] = 1;
                                        tmpMap[m][n] = 1;
                                        //DFS활용
                                        for (int o = 0; o < row; o++) {
                                            for (int p = 0; p < col; p++) {
                                                if (tmpMap[o][p] == 2) {
                                                    DFS(o, p, check, tmpMap);
                                                }
                                            }
                                        }
                                        //안전공간 세기
                                        int tmpAnswer = 0;
                                        for (int o = 0; o < row; o++) {
                                            for (int p = 0; p < col; p++) {
                                                if (tmpMap[o][p] == 0) {
                                                    tmpAnswer++;
                                                }
                                            }
                                        }
                                        answer = (tmpAnswer > answer) ? tmpAnswer : answer;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void DFS(int row, int col, boolean[][] check, int[][] tmpMap) {
        if (check[row][col]) return;
        check[row][col] = true;
        tmpMap[row][col] = 2;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int X = row + x[i];
            int Y = col + y[i];
            if (X >= 0 && X < check.length && Y >= 0 && Y < check[0].length && tmpMap[X][Y] == 0) {
                DFS(X, Y, check, tmpMap);
            }
        }
    }
}
