import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        map = new int[row][col];
        int x = Integer.parseInt(stringTokenizer1.nextToken());
        int y = Integer.parseInt(stringTokenizer1.nextToken());
        int direction = Integer.parseInt(stringTokenizer1.nextToken());
        answer = 0;
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer2.nextToken());
            }
        }
        //여기까지 입력완료
        boolean order1Check = true;
        int count = 0;
        while (true) {
            if (order1Check) {
                map[x][y] = 2;
                answer++;
                count = 0;
            }
            order1Check = true;
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            if (count == 4) {
                int X = x + dx[(direction + 2) % 4];
                int Y = y + dy[(direction + 2) % 4];
                if (map[X][Y] == 1) {
                    break;
                }
                x = X;
                y = Y;
                count = 0;
            }
            int X = x + dx[(direction + 3) % 4];
            int Y = y + dy[(direction + 3) % 4];
            if (map[X][Y] == 0) {
                x = X;
                y = Y;
                direction = (direction + 3) % 4;
                continue;
            }
            if (map[X][Y] == 2 || map[X][Y] == 1) {
                direction = (direction + 3) % 4;
                count++;
                order1Check = false;
                continue;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
