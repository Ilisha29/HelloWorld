package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 23 : 20 start
public class BOJ17144 {
    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[R][C];
        copyMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }

        int[] machineX = new int[2];
        int[] machineY = new int[2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    machineX[index] = i;
                    machineY[index] = j;
                    index++;
                }
            }
        }
        //==============입력 끝===============

        for (int i = 0; i < T; i++) {
            // 단계 1 확산 시작
            copyMap = new int[R][C];
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (map[j][k] > 4) {
                        int dustAmount = map[j][k] / 5;
                        int[] dx = {-1, 0, 1, 0};
                        int[] dy = {0, 1, 0, -1};
                        for (int l = 0; l < 4; l++) {
                            int X = j + dx[l];
                            int Y = k + dy[l];
                            if (X >= 0 && X < map.length && Y >= 0 && Y < map[0].length && map[X][Y] != -1) {
                                copyMap[X][Y] += dustAmount;
                                map[j][k] -= dustAmount;
                            }
                        }

                    }
                }
            }
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    map[j][k] += copyMap[j][k];
                }
            }
            // 단계 1 확산 끝

            // 단계 2 기계 가동 시작
            int CCWrep = 2 * (map[0].length - 1) + 2 * (machineX[0] - 0);
            int[] dx = new int[CCWrep];
            int[] dy = new int[CCWrep];
            int dindex = 0;
            for (int j = 0; j < machineX[0] - 0; j++) {
                dx[dindex] = -1;
                dy[dindex] = 0;
                dindex++;
            }
            for (int j = 0; j < map[0].length - 1; j++) {
                dx[dindex] = 0;
                dy[dindex] = 1;
                dindex++;
            }
            for (int j = 0; j < machineX[0] - 0; j++) {
                dx[dindex] = 1;
                dy[dindex] = 0;
                dindex++;
            }
            for (int j = 0; j < map[0].length - 1; j++) {
                dx[dindex] = 0;
                dy[dindex] = -1;
                dindex++;
            }
            int X = machineX[0];
            int Y = machineY[0];
            for (int j = 0; j < CCWrep; j++) {
                int X2 = X + dx[j];
                int Y2 = Y + dy[j];
                if (j == 0) {
                    map[X2][Y2] = 0;
                    X = X2;
                    Y = Y2;
                } else if (j == CCWrep - 1) {
                    map[X][Y] = 0;
                    X = X2;
                    Y = Y2;
                } else {
                    map[X][Y] = map[X2][Y2];
                    X = X2;
                    Y = Y2;
                }
            }
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();


            int CWrep = 2 * (map[0].length - 1) + 2 * (map.length - machineX[1] - 1);
            dx = new int[CWrep];
            dy = new int[CWrep];
            dindex = 0;
            for (int j = 0; j < map.length - machineX[1] - 1; j++) {
                dx[dindex] = 1;
                dy[dindex] = 0;
                dindex++;
            }
            for (int j = 0; j < map[0].length - 1; j++) {
                dx[dindex] = 0;
                dy[dindex] = 1;
                dindex++;
            }
            for (int j = 0; j < map.length - machineX[1] - 1; j++) {
                dx[dindex] = -1;
                dy[dindex] = 0;
                dindex++;
            }
            for (int j = 0; j < map[0].length - 1; j++) {
                dx[dindex] = 0;
                dy[dindex] = -1;
                dindex++;
            }
            X = machineX[1];
            Y = machineY[1];
            for (int j = 0; j < CWrep; j++) {
                int X2 = X + dx[j];
                int Y2 = Y + dy[j];
                if (j == 0) {
                    map[X2][Y2] = 0;
                    X = X2;
                    Y = Y2;
                } else if (j == CWrep - 1) {
                    map[X][Y] = 0;
                    X = X2;
                    Y = Y2;
                } else {
                    map[X][Y] = map[X2][Y2];
                    X = X2;
                    Y = Y2;
                }
                // 단계 2 기계 가동 끝
            }
            //=============가동 끝 ==============
        }
        //============ 결과 출력 =========
        int answer = 0;
        for (int m = 0; m < R; m++) {
            for (int j = 0; j < C; j++) {
                if (map[m][j] > 0) {
                    answer += map[m][j];
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
// 24 : 38 end
// 1시간 18분 걸림