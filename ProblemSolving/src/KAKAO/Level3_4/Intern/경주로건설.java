package KAKAO.Level3_4.Intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    public static void main(String[] args) {
        int[][][] boards = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
                {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}},
                {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}
        };

        for (int i = 0; i < boards.length; i++) {
            System.out.println(solution(boards[i]));
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int finish = board.length;
        int[][] price = new int[finish][finish];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(price[i], Integer.MAX_VALUE);
        }
        price[0][0] = 0;
        Queue<Hyundai> queue = new LinkedList<>();
        if (board[0][1] == 0) {
            queue.add(new Hyundai(0, 1, 1, 0, 1));
        }
        if (board[1][0] == 0) {
            queue.add(new Hyundai(1, 0, 1, 0, 2));
        }
        while (!queue.isEmpty()) {
            Hyundai hyundai = queue.poll();
            int tmpPrice = 100 * (hyundai.length) + 500 * (hyundai.corner);
            if (hyundai.x == finish - 1 && hyundai.y == finish - 1) {
                answer = Math.min(answer, tmpPrice);
                continue;
            }
            if (price[hyundai.x][hyundai.y] < tmpPrice) {
                continue;
            }
            price[hyundai.x][hyundai.y] = tmpPrice;

            int length = hyundai.length;
            int corner = hyundai.corner;
            for (int i = 0; i < 4; i++) {
                int X = hyundai.x + dx[i];
                int Y = hyundai.y + dy[i];
                if (X >= 0 && X < finish && Y >= 0 && Y < finish && board[X][Y] == 0) {
                    if (hyundai.direction == 1) {
                        if (i == 0 || i == 2) {
                            queue.add(new Hyundai(X, Y, length + 1, corner + 1, i));
                        } else if (i == hyundai.direction) {
                            queue.add(new Hyundai(X, Y, length + 1, corner, i));
                        }
                    } else if (hyundai.direction == 2) {
                        if (i == 1 || i == 3) {
                            queue.add(new Hyundai(X, Y, length + 1, corner + 1, i));
                        } else if (i == hyundai.direction) {
                            queue.add(new Hyundai(X, Y, length + 1, corner, i));
                        }
                    } else if (hyundai.direction == 3) {
                        if (i == 0 || i == 2) {
                            queue.add(new Hyundai(X, Y, length + 1, corner + 1, i));
                        } else if (i == hyundai.direction) {
                            queue.add(new Hyundai(X, Y, length + 1, corner, i));
                        }
                    } else {
                        if (i == 1 || i == 3) {
                            queue.add(new Hyundai(X, Y, length + 1, corner + 1, i));
                        } else if (i == hyundai.direction) {
                            queue.add(new Hyundai(X, Y, length + 1, corner, i));
                        }
                    }
                }
            }
        }
        return answer;
    }
}

class Hyundai {
    int x;
    int y;
    int length;
    int corner;

    public Hyundai(int x, int y, int length, int corner, int direction) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.corner = corner;
        this.direction = direction;
    }

    int direction;
}