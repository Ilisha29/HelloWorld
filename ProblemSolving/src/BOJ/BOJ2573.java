package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 10 : 25
public class BOJ2573 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = bufferedReader.readLine().split(" ");
        int row = Integer.parseInt(rowCol[0]);
        int col = Integer.parseInt(rowCol[1]);
        int[][] map = new int[row][col];
        long preUseMemory=Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int i = 0; i < map.length; i++) {
            String[] rows = bufferedReader.readLine().split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(rows[j]);
            }
        }
        int answerIndex = 0;
        while (true) {
            if (isAllZero(map)) {
                answerIndex = 0;
                break;
            }
            if (isAnswer(map)) {
                break;
            }
            answerIndex++;
            map = afterOneYear(map);
            long aftUserMemory=Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long useMemory=(aftUserMemory-preUseMemory);
            System.out.println(useMemory);
        }
        if (answerIndex == 0) {
            System.out.println(0);
        } else {
            System.out.println(answerIndex);
        }

        bufferedReader.close();
    }

    private static int[][] afterOneYear(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    int[] dx = {-1, 0, 1, 0};
                    int[] dy = {0, 1, 0, -1};
                    int seaCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int X = i + dx[k];
                        int Y = j + dy[k];
                        if (X >= 0 && X < map.length && Y >= 0 && Y < map[0].length && map[X][Y] == 0) {
                            seaCount++;
                        }
                    }
                    newMap[i][j] = map[i][j] - seaCount;
                    newMap[i][j] = Math.max(0, newMap[i][j]);
                }
            }
        }
        return newMap;
    }

    private static boolean isAnswer(int[][] map) {
        int[][] randCheck = new int[map.length][map[0].length];
        boolean[][] visit = new boolean[map.length][map[0].length];
        Queue<Dot> dots = new LinkedList<>();
        Dot dot = findDot(map);
        dots.offer(dot);
        while (!dots.isEmpty()) {
            Dot tmpDot = dots.poll();
            randCheck[tmpDot.x][tmpDot.y] = 1;
            visit[tmpDot.x][tmpDot.y] = true;
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int X = tmpDot.x + dx[i];
                int Y = tmpDot.y + dy[i];
                if (X >= 0 && X < map.length && Y >= 0 && Y < map[0].length && map[X][Y] != 0 && !visit[X][Y]) {
                    dots.offer(new Dot(X, Y));
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0 && randCheck[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Dot findDot(int[][] map) {
        Dot dot = new Dot(0, 0);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    dot.x = i;
                    dot.y = j;
                    return dot;
                }
            }
        }
        return dot;
    }

    private static boolean isAllZero(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}