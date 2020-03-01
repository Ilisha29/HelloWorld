import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2583 {
    static int[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int rep = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        check = new boolean[row][col];
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            int col1 = Integer.parseInt(stringTokenizer1.nextToken());
            int row1 = Integer.parseInt(stringTokenizer1.nextToken());
            int col2 = Integer.parseInt(stringTokenizer1.nextToken());
            int row2 = Integer.parseInt(stringTokenizer1.nextToken());
            for (int j = row1; j <= row2 - 1; j++) {
                for (int k = col1; k <= col2 - 1; k++) {
                    check[j][k] = true;
                }
            }
        }
        int num = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!check[i][j] && map[i][j] == 0) {
                    DFS(i, j, num);
                    num++;
                }
            }
        }
        int[] answer = new int[num - 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0) {
                    answer[map[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer.length);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        bufferedReader.close();
    }

    private static void DFS(int row, int col, int num) {
        if (check[row][col]) return;
        check[row][col] = true;
        map[row][col] = num;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int X = row + x[i];
            int Y = col + y[i];
            if (X >= 0 && X < map.length && Y >= 0 && Y < map[0].length) {
                DFS(X, Y, num);
            }
        }

    }
}
