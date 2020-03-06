package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260Practice {
    //예제 출력
    /*4 5 1
      1 2
      1 3
      1 4
      2 4
      3 4
      */
    /*
    1 2 4 3
    1 2 3 4
    */
    static int[][] graph;
    static int[] check;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        graph = new int[N + 1][N + 1];
        check = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(V);
        Arrays.fill(check, 0);
        System.out.println();
        bfs(V);
    }

    private static void bfs(int v) {
        queue.offer(v);
        check[v] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
            for (int i = 0; i < graph.length; i++) {
                if (check[i] == 0 && graph[i][n] == 1) {
                    queue.offer(i);
                    check[i] = 1;
                }
            }
        }
    }

    private static void dfs(int v) {
        if (check[v] == 1) return;

        check[v] = 1;
        System.out.print(v + " ");

        for (int i = 0; i < graph.length; i++) {
            if (graph[i][v] == 1 && check[i] == 0) {
                dfs(i);
            }
        }
    }
}
