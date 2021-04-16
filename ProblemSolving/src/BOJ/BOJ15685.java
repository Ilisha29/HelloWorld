package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15685 {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[101][101];
        int rep = Integer.parseInt(bufferedReader.readLine());
        int[] gerationIndex = new int[11];
        int[] dragonCurve = new int[1024];
        gerationIndex[0] = 1;
        for (int i = 1; i < gerationIndex.length; i++) {
            gerationIndex[i] = gerationIndex[i - 1] * 2;
        }
        dragonCurve[0] = 0;
        dragonCurve[1] = 1;
        for (int i = 2; i < 11; i++) {
            for (int j = gerationIndex[i - 1]; j < gerationIndex[i]; j++) {
                int tmp = dragonCurve[gerationIndex[i] - 1 - j];
                if (tmp == 3) {
                    tmp = 0;
                } else {
                    tmp++;
                }
                dragonCurve[j] = tmp;
            }
        }

        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int g = Integer.parseInt(stringTokenizer.nextToken());
            map[x][y] = true;
            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};
            for (int j = 0; j < gerationIndex[g]; j++) {
                int tmp = (dragonCurve[j] + d) % 4;
                x += dx[tmp];
                y += dy[tmp];
                map[x][y] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
