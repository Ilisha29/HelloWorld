package TEST.L;

public class P4 {
    public static void main(String[] args) {
        int[][] map = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
        System.out.println(solution(map));
    }

    public static int solution(int[][] maze) {
        int answer = 0;
        int n = maze.length;
        int[][] newMap = new int[n + 2][n + 2];
        for (int i = 0; i < newMap.length; i++) {
            newMap[i][0] = 1;
            newMap[i][newMap.length - 1] = 1;
            newMap[0][i] = 1;
            newMap[newMap.length - 1][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i + 1][j + 1] = maze[i][j];
            }
        }
        int x = 1;
        int y = 1;
        int lHandDirection = 0;
        if (newMap[x][y + 1] == 1)
            lHandDirection = 1;
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        int[] leftCheckX = {-1, 0, 1, 0};
        int[] leftCheckY = {0, 1, 0, -1};
        while (!(x == n && y == n)) {
            int frontX = x + moveX[lHandDirection];
            int frontY = y + moveY[lHandDirection];
            if (newMap[frontX][frontY] == 1) {
                lHandDirection++;
                lHandDirection %= 4;
            } else {
                x = frontX;
                y = frontY;
                answer++;
                if (newMap[x + leftCheckX[lHandDirection]][y + leftCheckY[lHandDirection]] != 1) {
                    x = x + leftCheckX[lHandDirection];
                    y = y + leftCheckY[lHandDirection];
                    lHandDirection--;
                    if (lHandDirection < 0)
                        lHandDirection = 3;
                    answer++;
                }
            }

            /*for (int i = 0; i < newMap.length; i++) {
                for (int j = 0; j < newMap.length; j++) {
                    if (i == x && j == y) {
                        System.out.print("#");
                    } else {
                        System.out.print(newMap[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println("answer : " + answer + " direction : " + lHandDirection);*/
        }
        return answer;
    }
}