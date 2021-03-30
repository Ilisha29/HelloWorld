package BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2573 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            array[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<Iceberg> icebergs = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] > 0) {
                    icebergs.add(new Iceberg(i, j, array[i][j]));
                }
            }
        }
        System.out.println(calculateAnswer(array, icebergs));
        bufferedReader.close();
    }

    private static int calculateAnswer(int[][] array, Queue<Iceberg> icebergs) {
        int answer = 0;
        int height = array.length;
        int width = array[0].length;
        while (!icebergs.isEmpty()) {
            if (isAnswer(array, icebergs)) {
                return answer;
            }
            int queueSize = icebergs.size();
            Queue<Iceberg> meltIceAmount = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                Iceberg iceberg = icebergs.poll();
                int amount = 0;
                for (int j = 0; j < 4; j++) {
                    int X = iceberg.x + dx[j];
                    int Y = iceberg.y + dy[j];
                    if (X >= 0 && X < height && Y >= 0 && Y < width && array[X][Y] == 0) {
                        amount++;
                    }
                }
                meltIceAmount.add(new Iceberg(iceberg.x, iceberg.y, amount));
                icebergs.add(iceberg);
            }
            int meltIceSize = meltIceAmount.size();
            for (int i = 0; i < meltIceSize; i++) {
                Iceberg origin = icebergs.poll();
                Iceberg melt = meltIceAmount.poll();
                int left = origin.length - melt.length;
                if (left > 0) {
                    array[origin.x][origin.y] = left;
                    origin.length = left;
                    icebergs.add(origin);
                } else {
                    array[origin.x][origin.y] = 0;
                }
            }
            answer++;
        }
        return 0;
    }

    private static boolean isAnswer(int[][] array, Queue<Iceberg> icebergs) {
        int N = array.length;
        int M = array[0].length;
        boolean[][] check = new boolean[N][M];
        int count = 1;
        int icebergSize = icebergs.size();
        for (int i = 0; i < icebergSize; i++) {
            Iceberg iceberg = icebergs.poll();
            if (!check[iceberg.x][iceberg.y]) {
                if (count == 2) return true;
                Queue<Point> checkSplit = new LinkedList<>();
                checkSplit.add(new Point(iceberg.x, iceberg.y));
                check[iceberg.x][iceberg.y] = true;
                while (!checkSplit.isEmpty()) {
                    Point point = checkSplit.poll();
                    for (int j = 0; j < 4; j++) {
                        int X = point.x + dx[j];
                        int Y = point.y + dy[j];
                        if (X >= 0 && X < N && Y >= 0 && Y < M && array[X][Y] > 0 && !check[X][Y]) {
                            check[X][Y] = true;
                            checkSplit.add(new Point(X, Y));
                        }
                    }
                }
                count++;
            }
            icebergs.add(iceberg);
        }
        return false;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Iceberg {
    int x;
    int y;
    int length;

    public Iceberg(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}
