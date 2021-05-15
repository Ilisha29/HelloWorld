package BOJ._3DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    private static int R;
    private static int C;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Ice> ices = new LinkedList<>();
        char[][] map = new char[R][C];
        int[][] swarovskies = new int[2][2];
        int swarovskiIndex = 0;
        for (int i = 0; i < R; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (input[j].charAt(0) == 'X') {
                    ices.add(new Ice(i, j, false));
                } else if (input[j].charAt(0) == 'L') {
                    swarovskies[swarovskiIndex][0] = i;
                    swarovskies[swarovskiIndex][1] = j;
                }
                map[i][j] = input[j].charAt(0);
            }
        }
        System.out.println(calculateAnswer(ices, swarovskies, map));
        bufferedReader.close();
    }

    private static int calculateAnswer(Queue<Ice> ices, int[][] swarovskies, char[][] map) {
        int answer = 0;
        boolean[][] visit = new boolean[R][C];
        while (!isAnswer(map, swarovskies, visit)) {
            int queueSize = ices.size();
            for (int i = 0; i < queueSize; i++) {
                Ice ice = ices.poll();
                for (int j = 0; j < 4; j++) {
                    int X = ice.x + dx[j];
                    int Y = ice.y + dy[j];
                    if (X >= 0 && X < R && Y >= 0 && Y < C && map[X][Y] != 'X') {
                        ice.isShouldDeleted = true;
                        break;
                    }
                }
                ices.add(ice);
            }
            for (int i = 0; i < queueSize; i++) {
                Ice ice = ices.poll();
                if (ice.isShouldDeleted) {
                    map[ice.x][ice.y] = '.';
                } else {
                    ices.add(ice);
                }
            }
            answer++;
        }
        return answer;
    }

    private static boolean isAnswer(char[][] map, int[][] swarovskies, boolean[][] visit) {
        visit[swarovskies[0][0]][swarovskies[0][1]] = true;
        Queue<Point4> point4Queue = new LinkedList<>();
        point4Queue.add(new Point4(swarovskies[0][0], swarovskies[0][1]));
        while (!point4Queue.isEmpty()) {
            Point4 point = point4Queue.poll();
            for (int i = 0; i < 4; i++) {
                int X = point.x + dx[i];
                int Y = point.y + dy[i];
                if (X >= 0 && X < R && Y >= 0 && Y < C && !visit[X][Y] && map[X][Y] != 'X') {
                    if (X == swarovskies[1][0] && Y == swarovskies[1][1]) {
                        return true;
                    }
                    visit[X][Y] = true;
                    point4Queue.add(new Point4(X, Y));
                }
            }
        }
        return false;
    }
}

class Ice {
    int x;
    int y;
    boolean isShouldDeleted;

    public Ice(int x, int y, boolean isShouldDeleted) {
        this.x = x;
        this.y = y;
        this.isShouldDeleted = isShouldDeleted;
    }
}

class Point4 {
    int x;
    int y;

    public Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
