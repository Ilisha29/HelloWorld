package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] check;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        check = new boolean[row][col];
        min = row * col;
        for (int i = 0; i < row; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int answer = 0;
        int startX = 0;
        int startY = 0;
        DFS(startX, startY, answer);
        System.out.println(min);
        bufferedReader.close();
    }

    private static void DFS(int startX, int startY, int answer) {
        if (check[startX][startY] || answer > min) {
            return;
        }
        check[startX][startY] = true;
        answer++;
        if (startX == map.length - 1 && startY == map[0].length - 1) {
            min = answer < min ? answer : min;
            return;
        }
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int x = startX + moveX[i];
            int y = startY + moveY[i];
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == 1 && !check[x][y]) { //!check[x][y] 이것도 내가 놓친핵심
                DFS(x, y, answer);
                check[x][y] = false; //이부분을 초기화해줘야 백트래킹으로 다시 돌아온다.. 내가 놓친 핵심
            }
        }
    }
}
