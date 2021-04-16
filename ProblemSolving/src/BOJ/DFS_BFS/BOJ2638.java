package BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
    private static int N;
    private static int M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<Point3> cheese = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    cheese.add(new Point3(i, j));
                }
            }
        }
        System.out.println(printAnswer(map, cheese));
        bufferedReader.close();
    }

    private static int printAnswer(int[][] map, Queue<Point3> cheese) {
        int answerTime = 0;
        while (!cheese.isEmpty()) {
            int[][] tmpMap = new int[N][M];
            checkOutSide(map, tmpMap);
            int cheeseSize = cheese.size();
            for (int i = 0; i < cheeseSize; i++) {
                Point3 point3 = cheese.poll();
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int X = point3.x + dx[j];
                    int Y = point3.y + dy[j];
                    if (X >= 0 && X < N && Y >= 0 && Y < M && tmpMap[X][Y] == 1) {
                        count++;
                    }
                }
                if (count >= 2) {
                    point3.isErase = true;
                }
                cheese.add(point3);
            }
            for (int i = 0; i < cheeseSize; i++) {
                Point3 point3 = cheese.poll();
                if (point3.isErase) {
                    map[point3.x][point3.y] = 0;
                } else {
                    cheese.add(point3);
                }
            }
            answerTime++;
        }
        return answerTime;
    }

    private static void checkOutSide(int[][] map, int[][] tmpMap) {
        int checkNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && tmpMap[i][j] == 0) {
                    tmpMap[i][j] = checkNum;
                    Queue<Point3> queue = new LinkedList<>();
                    queue.add(new Point3(i, j));
                    while (!queue.isEmpty()) {
                        Point3 point3 = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int X = point3.x + dx[k];
                            int Y = point3.y + dy[k];
                            if (X >= 0 && X < N && Y >= 0 & Y < M && tmpMap[X][Y] == 0 && map[X][Y] == 0) {
                                tmpMap[X][Y] = checkNum;
                                queue.add(new Point3(X, Y));
                            }
                        }
                    }
                    checkNum++;
                }
            }
        }
    }
}

class Point3 {
    int x;
    int y;
    boolean isErase;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
        this.isErase = false;
    }
}