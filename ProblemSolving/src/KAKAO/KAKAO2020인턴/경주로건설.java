package KAKAO.KAKAO2020인턴;

import java.util.LinkedList;
import java.util.Queue;

// 21 : 30
public class 경주로건설 {
    public static void main(String[] args) {
        //int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        //int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};

        System.out.println(solution(board));
    }

    //북 0, 동 1, 남 2, 서 3
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        Queue<Car2> carQueue = new LinkedList<>();
        int N = board.length;
        int[][] priceMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                priceMap[i][j] = Integer.MAX_VALUE;
            }
        }
        priceMap[0][0] = 0;
        if (board[0][1] == 0) {
            carQueue.offer(new Car2(0, 1, 1, 1, 0));
            priceMap[0][1] = 100;
        }
        if (board[1][0] == 0) {
            carQueue.offer(new Car2(1, 0, 1, 2, 0));
            priceMap[1][0] = 100;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!carQueue.isEmpty()) {
            Car2 car = carQueue.poll();
            if (car.x == N - 1 && car.y == N - 1) {
                int price = car.length * 100 + car.corner * 500;
                answer = price < answer ? price : answer;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int X = car.x + dx[i];
                int Y = car.y + dy[i];
                if (isComeback(car.direction, i)) {
                    continue;
                }
                if (X >= 0 && X <= N - 1 && Y >= 0 && Y <= N - 1 && board[X][Y] == 0) {
                    int len = car.length;
                    int direct = car.direction;
                    int corner = car.corner;
                    if (isCorner(direct, i)) {
                        corner++;
                    }
                    int tmpPrice = len * 100 + corner * 500;
                    if (tmpPrice <= priceMap[X][Y]) {
                        carQueue.offer(new Car2(X, Y, len + 1, i, corner));
                        priceMap[X][Y] = tmpPrice;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isComeback(int direction, int i) {
        if (direction == 0) {
            if (i == 2) {
                return true;
            }
        } else if (direction == 1) {
            if (i == 3) {
                return true;
            }
        } else if (direction == 2) {
            if (i == 0) {
                return true;
            }
        } else {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorner(int direct, int i) {
        if (direct == i) {
            return false;
        }
        return true;
    }

}

class Car2 {
    int x;
    int y;
    int direction;
    int corner;
    int length;

    Car2(int x, int y, int length, int direction, int corner) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.direction = direction;
        this.corner = corner;
    }
}
