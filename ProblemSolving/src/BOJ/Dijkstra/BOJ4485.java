package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ4485 {
    private static final int INF = 987654321;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            int[][] priceMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.fill(priceMap[i], INF);
            }
            PriorityQueue<Zelda> zeldas = new PriorityQueue<>(new Comparator<Zelda>() {
                @Override
                public int compare(Zelda o1, Zelda o2) {
                    return o1.price - o2.price;
                }
            });

            zeldas.add(new Zelda(0, 0, map[0][0]));
            while (!zeldas.isEmpty()) {
                Zelda zelda = zeldas.poll();
                if (priceMap[zelda.x][zelda.y] < zelda.price) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int X = zelda.x + dx[i];
                    int Y = zelda.y + dy[i];
                    if (X >= 0 && X < n && Y >= 0 && Y < n) {
                        int dist = map[X][Y] + zelda.price;
                        if (dist < priceMap[X][Y]) {
                            priceMap[X][Y] = dist;
                            zeldas.add(new Zelda(X, Y, dist));
                        }
                    }
                }
            }
            System.out.println("Problem " + problemNum + ": " + priceMap[n - 1][n - 1]);
            problemNum++;
        }
        bufferedReader.close();
    }
}

class Zelda {
    int x;
    int y;
    int price;

    public Zelda(int x, int y, int price) {
        this.x = x;
        this.y = y;
        this.price = price;
    }
}