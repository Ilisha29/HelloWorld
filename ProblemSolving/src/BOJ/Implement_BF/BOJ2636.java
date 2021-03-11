package BOJ.Implement_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2636 {
    private static int N;
    private static int M;
    private final static int[] dx = {-1, 0, 1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        if (isAllErasedCheck(map)){
            System.out.println(0);
            System.out.println(0);
        } else {
            calculateAnswer(map);
        }
        bufferedReader.close();
    }

    private static void calculateAnswer(int[][] map) {
        int years = 0;
        while (true) {
            int beforeCheeseCount = 0;
            int[][] findWhole = new int[N][M];
            int[][] deleteArea = new int[N][M];
            Queue<Point2> queue = new LinkedList<>();
            findWhole[0][0] = 2;
            queue.add(new Point2(0, 0));
            while (!queue.isEmpty()) {
                Point2 point2 = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int X = point2.x + dx[i];
                    int Y = point2.y + dy[i];
                    if (X>=0 && X < N && Y>=0 && Y < M && map[X][Y] == 0 && findWhole[X][Y] == 0){
                        findWhole[X][Y] = 2;
                        queue.add(new Point2(X, Y));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1){
                        beforeCheeseCount++;
                        for (int k = 0; k < 4; k++) {
                            int X = i + dx[k];
                            int Y = j + dy[k];
                            if (X>=0 && X < N && Y>=0 && Y < M && findWhole[X][Y] == 2){
                                deleteArea[i][j] = 1;
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] -= deleteArea[i][j];
                }
            }
            years++;
            if(isAllErasedCheck(map)){
                System.out.println(years);
                System.out.println(beforeCheeseCount);
                return;
            }
        }
    }

    private static boolean isAllErasedCheck(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
}

class Point2 {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
