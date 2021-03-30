package KAKAO.KAKAO2020인턴;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//우선순위큐로 접근하면 우선순위에 밀려 최소거리가 반영안되는경우가 있는거같다... 반례는 못찾겠다;;
public class 경주로건설2 {

    public static void main(String[] args) {
        int[][][] testCase = {
                {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
                {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}
        };
        for (int i = 0; i < testCase.length; i++) {
            System.out.println(solution(testCase[i]));
        }
    }

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int size = board.length;
        int[][] price = new int[size][size];
        for (int i = 0; i < price.length; i++) {
            Arrays.fill(price[i], Integer.MAX_VALUE);
        }
        price[0][0] = 0;
        PriorityQueue<KiaCar> priorityQueue = new PriorityQueue<>(new Comparator<KiaCar>() {
            @Override
            public int compare(KiaCar o1, KiaCar o2) {
                if (o1.price == o2.price) return o1.count - o2.count;
                return o1.price - o2.price;
            }
        });
        if (board[1][0] == 0) {
            priorityQueue.add(new KiaCar(1, 0, 100, 2, 1));
        }
        if (board[0][1] == 0) {
            priorityQueue.add(new KiaCar(0, 1, 100, 1, 1));
        }
        while (!priorityQueue.isEmpty()) {
            KiaCar kiaCar = priorityQueue.poll();
            if (kiaCar.x == size - 1 && kiaCar.y == size - 1) {
                answer = Math.min(answer, kiaCar.price);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int X = kiaCar.x + dx[i];
                int Y = kiaCar.y + dy[i];
                if (X >= 0 && X < size && Y >= 0 && Y < size && board[X][Y] == 0) {
                    if (kiaCar.direction % 2 == i % 2) {
                        if (kiaCar.direction == i) {
                            if (kiaCar.price + 100 <= price[X][Y]) {
                                priorityQueue.add(new KiaCar(X, Y, kiaCar.price + 100, i, kiaCar.count + 1));
                                price[X][Y] = kiaCar.price + 100;
                            }
                        }
                    } else {
                        if (kiaCar.price + 600 <= price[X][Y]) {
                            priorityQueue.add(new KiaCar(X, Y, kiaCar.price + 600, i, kiaCar.count + 1));
                            price[X][Y] = kiaCar.price + 600;
                        }
                    }
                }

            }
        }
        return answer;
    }
}

class KiaCar {
    int x;
    int y;
    int price;
    int direction;
    int count;

    public KiaCar(int x, int y, int price, int direction, int count) {
        this.x = x;
        this.y = y;
        this.price = price;
        this.direction = direction;
        this.count = count;
    }
}
