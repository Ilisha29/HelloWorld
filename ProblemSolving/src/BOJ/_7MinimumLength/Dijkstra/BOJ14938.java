package BOJ._7MinimumLength.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int[] items = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            adjMatrix[to][from] = length;
            adjMatrix[from][to] = length;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int[] table = new int[n + 1];
            int tmpAnswer = 0;
            Arrays.fill(table, Integer.MAX_VALUE);
            table[i] = 0;
            PriorityQueue<Point3> priorityQueue = new PriorityQueue<>(new Comparator<Point3>() {
                @Override
                public int compare(Point3 o1, Point3 o2) {
                    return o1.length - o2.length;
                }
            });
            priorityQueue.add(new Point3(i, 0));
            while (!priorityQueue.isEmpty()) {
                Point3 point3 = priorityQueue.poll();
                if (table[point3.to] < point3.length) {
                    continue;
                }
                table[point3.to] = point3.length;
                for (int j = 1; j < n + 1; j++) {
                    if (adjMatrix[point3.to][j] != 0) {
                        int dist = point3.length + adjMatrix[point3.to][j];
                        if (dist < table[j]) {
                            table[j] = dist;
                            priorityQueue.add(new Point3(j, dist));
                        }
                    }
                }
            }
            System.out.println("case"+i);
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[j]+" ");
            }
            System.out.println();
            for (int j = 1; j < table.length; j++) {
                if (table[j] <= m) {
                    tmpAnswer += items[j - 1];
                }
            }
            System.out.println(tmpAnswer);
            System.out.println("case end =========");
            answer = Math.max(answer, tmpAnswer);
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

class Point3 {
    int to;
    int length;

    public Point3(int to, int length) {
        this.to = to;
        this.length = length;
    }
}
