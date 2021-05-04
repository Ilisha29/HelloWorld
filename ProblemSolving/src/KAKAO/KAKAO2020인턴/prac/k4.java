package KAKAO.KAKAO2020인턴.prac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class k4 {
    public static void main(String[] args) {
        int[][][] board = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
                {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}},
                {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}
        };
        for (int i = 0; i < board.length; i++) {
            System.out.println(solution(board[i]));
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[][] priceMap = new int[board.length][board.length];
        int finish = board.length - 1;
        for (int i = 0; i < priceMap.length; i++) {
            Arrays.fill(priceMap[i], Integer.MAX_VALUE);
        }
        priceMap[0][0] = 0;
        Queue<Car> carQueue = new LinkedList<>();
        if (board[0][1] == 0) {
            carQueue.add(new Car(0, 1, 1, 0, 1));
        }
        if (board[1][0] == 0) {
            carQueue.add(new Car(1, 0, 1, 0, 2));
        }
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            int price = 100 * car.length + 500 * car.corner;
            if (car.x == finish && car.y == finish) {
                answer = Math.min(price, answer);
                continue;
            }
            if (priceMap[car.x][car.y] < price) {
                continue;
            }
            priceMap[car.x][car.y] = price;
            for (int i = 0; i < 4; i++) {
                int X = car.x + dx[i];
                int Y = car.y + dy[i];
                if (X >= 0 && X <= finish && Y >= 0 && Y <= finish && board[X][Y] == 0) {
                    Car tmpCar = new Car(X, Y, car.length + 1, car.corner, i);
                    if (car.direction == 0) {
                        if (i == 1 || i == 3) {
                            tmpCar.corner++;
                        }
                    } else if (car.direction == 1) {
                        if (i == 0 || i == 2) {
                            tmpCar.corner++;
                        }
                    } else if (car.direction == 2) {
                        if (i == 1 || i == 3) {
                            tmpCar.corner++;
                        }
                    } else if (car.direction == 3) {
                        if (i == 0 || i == 2) {
                            tmpCar.corner++;
                        }
                    }
                    carQueue.add(tmpCar);
                }
            }
        }
        return answer;
    }
}

class Car {
    int x;
    int y;
    int length;
    int corner;
    int direction;

    public Car(int x, int y, int length, int corner, int direction) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.corner = corner;
        this.direction = direction;
    }
}
