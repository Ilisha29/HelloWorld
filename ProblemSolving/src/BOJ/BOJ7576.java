package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//15 : 50 start
public class BOJ7576 {
    static int[][] map;
    static boolean[][] check;
    static Queue<Integer> queueX;
    static Queue<Integer> queueY;
    static Queue<Integer> queueLength;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }

        //토마토 익을게 있는지 확인
        int answer = 0;
        int notTomato = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    notTomato++;
                }
            }
        }
        if (notTomato == 0) {
            System.out.println(answer);
        } else {
            int tomatoNum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1) {
                        tomatoNum++;
                    }
                }
            }
            int[] tomatoX = new int[tomatoNum];
            int[] tomatoY = new int[tomatoNum];
            int index = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1) {
                        tomatoX[index] = i;
                        tomatoY[index] = j;
                        index++;
                    }
                }
            }
            check = new boolean[row][col];
            queueX = new LinkedList<>();
            queueY = new LinkedList<>();
            queueLength = new LinkedList<>();
            for (int i = 0; i < tomatoNum; i++) {
                queueX.offer(tomatoX[i]);
                queueY.offer(tomatoY[i]);
                queueLength.offer(answer);
            }

            while (!queueX.isEmpty()) {
                int[] dx = {-1, 0, 1, 0};
                int[] dy = {0, 1, 0, -1};
                int x = queueX.poll();
                int y = queueY.poll();
                answer = queueLength.poll();
                for (int i = 0; i < 4; i++) {
                    int X = x + dx[i];
                    int Y = y + dy[i];
                    if (X >= 0 && X < map.length && Y >= 0 && Y < map[0].length && map[X][Y] == 0) {
                        queueX.offer(X);
                        queueY.offer(Y);
                        map[X][Y] = 1;
                        queueLength.offer(answer + 1);
                    }
                }

            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 0) {
                        answer = -1;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
        bufferedReader.close();
    }
}
// 17 : 10 end
