package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14891 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int rep = Integer.parseInt(bufferedReader.readLine());
        int[][] orders = new int[rep][2];
        for (int i = 0; i < rep; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            orders[i][0] = Integer.parseInt(strings[0]);
            orders[i][1] = Integer.parseInt(strings[1]);
        }
        for (int i = 0; i < rep; i++) {
            int gearNum = orders[i][0] - 1;
            int clockWise = orders[i][1];
            boolean[][] canMoveGear = new boolean[4][2];
            canMoveGear[gearNum][0] = true;
            if (clockWise == 1) {
                canMoveGear[gearNum][1] = true;
            } else {
                canMoveGear[gearNum][1] = false;
            }
            if (gearNum == 0) {
                if (map[0][2] != map[1][6]) {
                    canMoveGear[1][0] = true;
                    canMoveGear[1][1] = !canMoveGear[0][1];
                    if (map[1][2] != map[2][6]) {
                        canMoveGear[2][0] = true;
                        canMoveGear[2][1] = !canMoveGear[1][1];
                        if (map[2][2] != map[3][6]) {
                            canMoveGear[3][0] = true;
                            canMoveGear[3][1] = !canMoveGear[2][1];
                        }
                    }
                }
            } else if (gearNum == 1) {
                if (map[1][6] != map[0][2]) {
                    canMoveGear[0][0] = true;
                    canMoveGear[0][1] = !canMoveGear[1][1];
                }
                if (map[1][2] != map[2][6]) {
                    canMoveGear[2][0] = true;
                    canMoveGear[2][1] = !canMoveGear[1][1];
                    if (map[2][2] != map[3][6]) {
                        canMoveGear[3][0] = true;
                        canMoveGear[3][1] = !canMoveGear[2][1];
                    }
                }

            } else if (gearNum == 2) {
                if (map[2][6] != map[1][2]) {
                    canMoveGear[1][0] = true;
                    canMoveGear[1][1] = !canMoveGear[2][1];
                    if (map[1][6] != map[0][2]) {
                        canMoveGear[0][0] = true;
                        canMoveGear[0][1] = !canMoveGear[1][1];
                    }
                }
                if (map[2][2] != map[3][6]) {
                    canMoveGear[3][0] = true;
                    canMoveGear[3][1] = !canMoveGear[2][1];
                }

            } else if (gearNum == 3) {
                if (map[3][6] != map[2][2]) {
                    canMoveGear[2][0] = true;
                    canMoveGear[2][1] = !canMoveGear[3][1];
                    if (map[2][6] != map[1][2]) {
                        canMoveGear[1][0] = true;
                        canMoveGear[1][1] = !canMoveGear[2][1];
                        if (map[1][6] != map[0][2]) {
                            canMoveGear[0][0] = true;
                            canMoveGear[0][1] = !canMoveGear[1][1];
                        }
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                if (canMoveGear[j][0]) {
                    if (canMoveGear[j][1]) { //시계방향
                        CW(map[j], j);
                    } else { //반시계
                        CCW(map[j], j);
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                if (map[i][0] == 1) {
                    answer += 1;
                }
            } else if (i == 1) {
                if (map[i][0] == 1) {
                    answer += 2;
                }
            } else if (i == 2) {
                if (map[i][0] == 1) {
                    answer += 4;
                }
            } else{
                if (map[i][0] == 1) {
                    answer += 8;
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void CCW(int[] ints, int j) {
        int[] tmp = new int[8];
        for (int i = 0; i < 7; i++) {
            tmp[i] = ints[i + 1];
        }
        tmp[7] = ints[0];
        for (int i = 0; i < 8; i++) {
            map[j][i] = tmp[i];
        }
    }

    private static void CW(int[] ints, int j) {
        int[] tmp = new int[8];
        for (int i = 1; i < 8; i++) {
            tmp[i] = ints[i - 1];
        }
        tmp[0] = ints[7];
        for (int i = 0; i < 8; i++) {
            map[j][i] = tmp[i];
        }
    }
}
