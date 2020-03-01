import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2667 {
    static int[][] map;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        check = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int aptNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && check[i][j] == 0) {
                    DFS(i, j, aptNum);
                    aptNum++;
                }
            }
        }
        int[] answer = new int[aptNum - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j] != 0) {
                    answer[check[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer.length);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        bufferedReader.close();
    }

    private static void DFS(int i, int j, int aptNum) {
        check[i][j] = aptNum;
        int[] sumX = {-1, 0, 1, 0};
        int[] sumY = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + sumX[k];
            int y = j + sumY[k];
            if (x >= 0 && y >= 0 && x < map.length && y < map.length && map[x][y] == 1 && check[x][y] == 0) {
                DFS(x, y, aptNum);
            }
        }
    }
}
