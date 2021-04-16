package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int rep = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        int[][] repCycle = new int[rep][3];
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                repCycle[i][j] = Integer.parseInt(stringTokenizer2.nextToken());
            }
        }


        bufferedReader.close();
    }
}
