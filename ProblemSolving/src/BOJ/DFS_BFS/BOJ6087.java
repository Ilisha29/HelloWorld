package BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6087 {
    private static int W;
    private static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] startEnd = new int[2][2];
        int startEndIndex = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        W = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == 'C') {
                    startEnd[startEndIndex][0] = i;
                    startEnd[startEndIndex][1] = j;
                    startEndIndex++;
                }
                map[i][j] = input.charAt(j);
            }
        }
        System.out.println(calculateAnswer(startEnd, map));
        bufferedReader.close();
    }

    private static int calculateAnswer(int[][] startEnd, char[][] map) {
        int[][] corner = new int[H][W];

        return 0;
    }
}
