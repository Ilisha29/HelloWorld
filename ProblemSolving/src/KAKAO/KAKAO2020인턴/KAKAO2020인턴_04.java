package KAKAO.KAKAO2020인턴;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO2020인턴_04 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board1 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board2 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution(board1));
    }

    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 0 = 위 1 = 오 2 = 아래 3 = 왼;
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        N = board.length;
        Queue<Car> carQueue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }
        visited[0][0] = true;
        if (board[0][1] == 0) {
            boolean[][] newVisite = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        newVisite[i][j] = true;
                    }
                }
            }
            newVisite[0][1] = true;
            Car car = new Car(0, 1, 1, 100, newVisite);
            carQueue.offer(car);

        }

        if (board[1][0] == 0) {
            boolean[][] newVisite = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        newVisite[i][j] = true;
                    }
                }
            }
            newVisite[1][0] = true;
            Car car = new Car(1, 0, 2, 100, newVisite);
            carQueue.offer(car);
        }
        //[[0,0,1,0],
        // [0,0,0,0],
        // [0,1,0,1],
        // [1,0,0,0]]

        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            int X = car.x;
            int Y = car.y;
            int Price = car.price;

            if (X == N - 1 && Y == N - 1) {
                answer = Price < answer ? Price : answer;
            } else {
                int BeforeDirection = car.beforeDirection;
                boolean[][] Visted = car.visted;
                for (int i = 0; i < 4; i++) {
                    int newX = X + dx[i];
                    int newY = Y + dy[i];
                    if (newX >= 0 && newX < N && newY >= 0 && newY < N && !Visted[newX][newY]) {
                        boolean[][] newVisite = new boolean[N][N];
                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < N; n++) {
                                if (Visted[m][n]) {
                                    newVisite[m][n] = true;
                                }
                            }
                        }
                        newVisite[newX][newY] = true;
                        if ((BeforeDirection + i) % 2 == 0) { //100원
                            carQueue.add(new Car(newX, newY, i, Price + 100, newVisite));
                        } else { // 500원
                            carQueue.add(new Car(newX, newY, i, Price + 600, newVisite));
                        }

                    }
                }
            }
        }
        return answer;
    }
}

class Car {
    public int x;
    public int y;
    public int price;
    public int beforeDirection;
    public boolean[][] visted;

    public Car(int x, int y, int beforeDirection, int price, boolean[][] visted) {
        this.x = x;
        this.y = y;
        this.beforeDirection = beforeDirection;
        this.price = price;
        this.visted = visted;
    }

}