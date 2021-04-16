package 코테대비책.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[][] map = new int[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())];
        boolean[][] visit = new boolean[map.length][map[0].length];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());
        int directions = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < map.length; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visit[X][Y] = true;
        int answer = 1;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (directions == 0) {
                    directions = 3;
                } else {
                    directions--;
                }
                int newX = X + dx[directions];
                int newY = Y + dy[directions];



                if (0 <= newX && newX <= map.length && 0 <= newY && newY <= map[0].length && map[newX][newY] == 0 && !visit[newX][newY]) {
                    X = newX;
                    Y = newY;
                    visit[X][Y] = true;
                    answer++;
                    continue;
                }
            }
            int newDirections = (directions + 2) % 4;
            if (map[X + dx[newDirections]][Y + dy[newDirections]] == 1) {
                break;
            }
            X += dx[newDirections];
            Y += dy[newDirections];
            answer++;
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
/*
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
*/