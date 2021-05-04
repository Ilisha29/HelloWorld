package KAKAO.KAKAO2020공채;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동2 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(solution(board));
    }

    private static int finishX;
    private static int finishY;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        int answer = 0;
        finishX = board.length;
        finishY = board[0].length;
        boolean[][] visit = new boolean[finishX][finishY];
        Queue<Car> queue = new LinkedList<>();
        queue.add(new Car(0, 0, 1, 0));
        while (true) {
            Car car = queue.poll();
            if (isFinish(car)) {
                answer = car.move;
                break;
            }
        }
        return answer;
    }

    private static boolean isFinish(Car car) {
        int x1 = car.x1;
        int y1 = car.y1;
        if ((x1 == finishX && y1 == finishY) || (x1 + dx[car.direction] == finishX && y1 + dy[car.direction] == finishY)) {
            return true;
        }
        return false;
    }
}

class Car {
    int x1;
    int y1;
    int direction;
    int move;

    public Car(int x1, int y1, int direction, int move) {
        this.x1 = x1;
        this.y1 = y1;
        this.direction = direction;
        this.move = move;
    }
}
