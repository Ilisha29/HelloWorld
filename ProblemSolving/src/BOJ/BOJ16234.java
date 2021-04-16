package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 23:45 start
public class BOJ16234 {
    static int[][] map;
    static boolean[][] check;
    static int[][] map2;
    static int L;
    static int R;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 0;
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }

        //결과 출력
        boolean repPossible = false;
        while (true) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < 4; k++) {
                        int X = i + dx[k];
                        int Y = j + dy[k];
                        if (X >= 0 && X < size && Y >= 0 && Y < size) {
                            int gap = Math.abs(map[i][j] - map[X][Y]);
                            if (gap >= L && gap <= R) {
                                repPossible = true;
                            }
                        }
                    }
                }
            }
            if (repPossible) {
                answer++;
                map2 = new int[size][size];
                check = new boolean[size][size];
                int mapNum = 1;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < 4; k++) {
                            int X = i + dx[k];
                            int Y = j + dy[k];
                            if (X >= 0 && X < size && Y >= 0 && Y < size && !check[X][Y]) {
                                int gap = Math.abs(map[i][j] - map[X][Y]);
                                if (gap >= L && gap <= R) {
                                    DFS(i, j, mapNum);
                                    mapNum++;
                                }
                            }
                        }

                    }
                }
                for (int i = 1; i <= mapNum - 1; i++) {
                    int tmpSum = 0;
                    int count = 0;
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            if (map2[j][k] == i) {
                                tmpSum += map[j][k];
                                count++;
                            }
                        }
                    }
                    int num = 0;
                    if (count != 0) {
                        num = tmpSum / count;
                    }
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            if (map2[j][k] == i) {
                                map[j][k] = num;
                            }
                        }
                    }
                }
                repPossible = false;
            } else {
                break;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void DFS(int i, int j, int mapNum) {
        if (check[i][j]) return;
        check[i][j] = true;
        map2[i][j] = mapNum;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int X = i + dx[k];
            int Y = j + dy[k];
            if (X >= 0 && X < map.length && Y >= 0 && Y < map.length && !check[X][Y]) {
                int gap = Math.abs(map[i][j] - map[X][Y]);
                if (gap >= L && gap <= R) {
                    DFS(X, Y, mapNum);
                }
            }
        }
    }
}
// 01 : 00 end
// 휴식 빼고 한시간
