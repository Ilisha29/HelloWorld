package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Virus> virus = new ArrayList<Virus>();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                map[i][j] = num;
                if (num != 0) {
                    virus.add(new Virus(i, j, 0, num));
                }
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Virus> queue = new LinkedList<>();
        Collections.sort(virus);
        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int tmpx = queue.peek().X;
            int tmpy = queue.peek().Y;
            int tmptime = queue.peek().time;
            int tmpnum = queue.poll().num;
            if (tmptime < S) {
                for (int i = 0; i < 4; i++) {
                    int newX = tmpx + dx[i];
                    int newY = tmpy + dy[i];
                    if (0 <= newX && newX <= N - 1 && 0 <= newY && newY <= N - 1 && map[newX][newY] == 0) {
                        map[newX][newY] = tmpnum;
                        queue.offer(new Virus(newX, newY, tmptime + 1, tmpnum));
                    }
                }
            }
        }
        System.out.println(map[X - 1][Y - 1]);
        bufferedReader.close();
    }
}

class Virus implements Comparable<Virus> {
    int X;
    int Y;
    int time;
    int num;

    Virus(int X, int Y, int time, int num) {
        this.X = X;
        this.Y = Y;
        this.time = time;
        this.num = num;
    }

    @Override
    public int compareTo(Virus o) {
        if (this.num > o.num) {
            return 1;
        } else if (this.num < o.num) {
            return -1;
        } else {
            return 0;
        }
    }
}