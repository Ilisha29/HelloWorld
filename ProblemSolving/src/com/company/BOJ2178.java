package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] check;
    static int min;
    static Queue<Integer> queueX;
    static Queue<Integer> queueY;
    static Queue<Integer> level;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        check = new boolean[row][col];
        min = row * col;
        queueX = new LinkedList<>();
        queueY = new LinkedList<>();
        level = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int answer = 0;
        int startX = 0;
        int startY = 0;
        BFS(startX, startY, answer);
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

    private static void BFS(int startX, int startY, int start) {
        queueX.offer(startX);
        queueY.offer(startY);
        level.offer(start);
        while (!queueX.isEmpty() && !queueY.isEmpty() && !level.isEmpty()) {
            int X = queueX.poll();
            int Y = queueY.poll();
            int answer = level.poll();
            if (check[X][Y]) continue; // 여기!!! 헷갈린다.
            check[X][Y] = true;
            answer++;
            if (X == map.length - 1 && Y == map[0].length - 1) {
                min = answer < min ? answer : min;
                return; // 있는게 더 시간 단축일듯
            }
            int[] moveX = {-1, 0, 1, 0};
            int[] moveY = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int x = X + moveX[i];
                int y = Y + moveY[i];
                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == 1 && !check[x][y]) { // 여기!!! !check[x][y] 헷갈린다.
                    queueX.offer(x);
                    queueY.offer(y);
                    level.offer(answer);
                }
            }
        }
    }
}
