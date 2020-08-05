package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ps06 {
    //0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(";");
        int row = strings.length;
        int col = strings[0].split(" ").length;
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] toInt = strings[i].split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(toInt[j]);
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int length = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int X = i + dx[k];
                        int Y = j + dy[k];
                        if (X >= 0 && X < row && Y >= 0 && Y < col) {
                            if (map[X][Y] == 1) {
                                length++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(length);
        bufferedReader.close();
    }
}
