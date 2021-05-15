package BOJ._7MinimumLength.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ11780_must_review {
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int line = Integer.parseInt(bufferedReader.readLine());
        int[][] adjMatrix = new int[N + 1][N + 1];
        int[][] passThrough = new int[N + 1][N + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            Arrays.fill(adjMatrix[i], INF);
            adjMatrix[i][i] = 0;
        }

        for (int i = 0; i < line; i++) {
            int[] busInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (busInfo[2] < adjMatrix[busInfo[0]][busInfo[1]]) {
                adjMatrix[busInfo[0]][busInfo[1]] = busInfo[2];
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                        passThrough[i][j] = k;
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (adjMatrix[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(adjMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (adjMatrix[i][j] == 0 || adjMatrix[i][j] == INF) {
                    System.out.println("0");
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    routeList(i, j, passThrough, list);
                    System.out.print(list.size() + " ");
                    for (int k = 0; k < list.size(); k++) {
                        System.out.print(list.get(k) + " ");
                    }
                    System.out.println();
                }
            }
        }
        bufferedReader.close();
    }

    public static void routeList(int start, int end, int route[][], LinkedList<Integer> list) {
        if (route[start][end] == 0) { // i~j를 갈 때 거치는 점이 없을
            list.add(start);
            if (start != end) {
                list.add(end);
            }
        } else {
            int middle = route[start][end]; // i~j를 갈 때 경유
            routeList(start, middle, route, list);
            list.removeLast(); // 중복 제거
            routeList(middle, end, route, list);
        }
    }
}
