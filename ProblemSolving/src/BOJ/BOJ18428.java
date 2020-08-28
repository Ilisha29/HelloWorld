package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15 : 30
public class BOJ18428 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[][] map = new String[N][N];
        int[][] ticher = new int[5][2];
        for (int i = 0; i < ticher.length; i++) {
            for (int j = 0; j < 2; j++) {
                ticher[i][j] = -1;
            }
        }
        int ticherIndex = 0;
        StringTokenizer stringTokenizer;
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                String string = stringTokenizer.nextToken();
                map[i][j] = string;
                if (string.equals("T")) {
                    ticher[ticherIndex][0] = i;
                    ticher[ticherIndex++][1] = j;
                }
            }
        }
        int[][] indexMap = new int[N * N][2];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                indexMap[index][0] = i;
                indexMap[index++][1] = j;
            }
        }
        boolean answer = false;
        for (int i = 0; i < N * N - 2; i++) {
            for (int j = i + 1; j < N * N - 1; j++) {
                for (int k = j + 1; k < N * N; k++) {
                    if (map[indexMap[i][0]][indexMap[i][1]].equals("X") && map[indexMap[j][0]][indexMap[j][1]].equals("X") && map[indexMap[k][0]][indexMap[k][1]].equals("X")) {
                        map[indexMap[i][0]][indexMap[i][1]] = "O";
                        map[indexMap[j][0]][indexMap[j][1]] = "O";
                        map[indexMap[k][0]][indexMap[k][1]] = "O";
                        boolean cantSeeStudent = true;
                        for (int l = 0; l < ticher.length; l++) {
                            if (ticher[l][0] != -1) {
                                int X = ticher[l][0];
                                int Y = ticher[l][1];
                                for (int m = 0; m < 4; m++) {
                                    if (isSeeStudent(X, Y, m, map)) {
                                        cantSeeStudent = false;
                                        break;
                                    }
                                }
                            }
                        }
                        if (cantSeeStudent) {
                            answer = true;
                            break;
                        }
                        map[indexMap[i][0]][indexMap[i][1]] = "X";
                        map[indexMap[j][0]][indexMap[j][1]] = "X";
                        map[indexMap[k][0]][indexMap[k][1]] = "X";
                    }
                }
            }
        }
        if (answer)
            System.out.println("YES");
        else
            System.out.println("NO");
        bufferedReader.close();
    }

    private static boolean isSeeStudent(int x, int y, int m, String[][] map) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (true) {
            x += dx[m];
            y += dy[m];
            if (0 <= x && x < map.length && 0 <= y && y < map.length) {
                if (map[x][y].equals("O")) {
                    break;
                } else if (map[x][y].equals("S")) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
