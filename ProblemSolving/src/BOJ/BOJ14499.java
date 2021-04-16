package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17 : 37 start
public class BOJ14499 {
    static int[][] map;
    static int[] orders;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int diceX = Integer.parseInt(stringTokenizer.nextToken());
        int diceY = Integer.parseInt(stringTokenizer.nextToken());
        int order = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        orders = new int[order];
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < order; i++) {
            orders[i] = Integer.parseInt(stringTokenizer1.nextToken());
        }
        int[][] diceMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < order; i++) {
            int[] dx = {0, 0, 0, -1, 1};
            int[] dy = {0, 1, -1, 0, 0};
            int X = diceX + dx[orders[i]];
            int Y = diceY + dy[orders[i]];
            if (X < 0 || X >= row || Y < 0 || Y >= col) {
                continue;
            } else {
                diceX += dx[orders[i]];
                diceY += dy[orders[i]];
                int[][] tmpDice = new int[4][3];
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 3; k++) {
                        tmpDice[j][k] = diceMap[j][k];
                    }
                }
                if (orders[i] == 1) { //east
                    diceMap[1][1] = tmpDice[1][0];//위
                    diceMap[1][2] = tmpDice[1][1];//동
                    if (map[diceX][diceY] == 0) { // 아래
                        diceMap[3][1] = tmpDice[1][2];
                        map[diceX][diceY] = tmpDice[1][2];
                    } else {
                        diceMap[3][1] = map[diceX][diceY];
                        map[diceX][diceY] = 0;
                    }
                    diceMap[1][0] = tmpDice[3][1];//서
                    //diceMap[2][1] = tmpDice[][];//정면
                    //diceMap[0][1] = tmpDice[][];//뒤

                } else if (orders[i] == 2) { //west
                    diceMap[1][1] = tmpDice[1][2];//위
                    diceMap[1][2] = tmpDice[3][1];//동
                    if (map[diceX][diceY] == 0) { // 아래
                        diceMap[3][1] = tmpDice[1][0];
                        map[diceX][diceY] = tmpDice[1][0];
                    } else {
                        diceMap[3][1] = map[diceX][diceY];
                        map[diceX][diceY] = 0;
                    }
                    diceMap[1][0] = tmpDice[1][1];//서
                    //diceMap[2][1] = tmpDice[][];//정면
                    //diceMap[0][1] = tmpDice[][];//뒤

                } else if (orders[i] == 3) { //north
                    diceMap[1][1] = tmpDice[2][1];//위
                    //diceMap[1][2] = tmpDice[][];//동
                    if (map[diceX][diceY] == 0) { // 아래
                        diceMap[3][1] = tmpDice[0][1];
                        map[diceX][diceY] = tmpDice[0][1];
                    } else {
                        diceMap[3][1] = map[diceX][diceY];
                        map[diceX][diceY] = 0;
                    }
                    //diceMap[1][0] = tmpDice[][];//서
                    diceMap[2][1] = tmpDice[3][1];//정면
                    diceMap[0][1] = tmpDice[1][1];//뒤
                } else { //south
                    diceMap[1][1] = tmpDice[0][1];//위
                    //diceMap[1][2] = tmpDice[][];//동
                    if (map[diceX][diceY] == 0) { // 아래
                        diceMap[3][1] = tmpDice[2][1];
                        map[diceX][diceY] = tmpDice[2][1];
                    } else {
                        diceMap[3][1] = map[diceX][diceY];
                        map[diceX][diceY] = 0;
                    }
                    //diceMap[1][0] = tmpDice[][];//서
                    diceMap[2][1] = tmpDice[1][1];//정면
                    diceMap[0][1] = tmpDice[3][1];//뒤
                }
                System.out.println(diceMap[1][1]);
            }
        }
        bufferedReader.close();
    }
}
// 18:36 end