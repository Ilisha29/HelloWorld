package TEST.K;

public class PS04 {
    public static void main(String[] args) {
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(6, 4, 6, 2, fares));
    }

    static int[][] matrix;
    static boolean[] visit;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 100000;
        int[] answers = new int[n + 1];
        matrix = new int[201][201];
        matrix = setDefaultValue();

        for (int i = 0; i < fares.length; i++) {
            matrix[fares[i][0]][fares[i][1]] = fares[i][2];
            matrix[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        int[] sMD = dij(s, n);
        int[] aMD = dij(a, n);
        int[] bMD = dij(b, n);

        for (int i = 1; i <= n; i++) {
            answers[i] += sMD[i] + aMD[i] + bMD[i];
            if (answers[i] < answer && answers[i] > 0) {
                answer = answers[i];
            }
        }
        return answer;
    }

    private static int[] dij(int s, int n) {
        int[] distance = new int[201];

        visit = new boolean[201];
        for (int i = 1; i <= n; i++) {
            visit[i] = false;
        }

        for (int i = 1; i <= n; i++) {
            distance[i] = matrix[s][i];
        }
        visit[s] = true;

        for (int i = 0; i < n - 2; i++) {
            int tmp = findMinNum(n, distance);
            visit[tmp] = true;

            for (int j = 1; j <= n; j++) {
                if (visit[j])
                    continue;
                if (distance[tmp] + matrix[tmp][j] < distance[j]) {
                    distance[j] = distance[tmp] + matrix[tmp][j];
                }
            }
        }
        return distance;
    }

    private static int findMinNum(int n, int[] distance) {
        int min = 100000;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i])
                continue;
            if (distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    private static int[][] setDefaultValue() {
        int[][] matrix = new int[201][201];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (i == j)
                    continue;
                matrix[i][j] = 100000;
            }
        }
        return matrix;
    }
}