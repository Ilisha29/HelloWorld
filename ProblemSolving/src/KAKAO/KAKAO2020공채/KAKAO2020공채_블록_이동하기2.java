package KAKAO.KAKAO2020공채;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO2020공채_블록_이동하기2 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    static int[][] map;
    static int size;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        size = board.length;
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = board[i][j];
            }
        }
        Queue<Robot2> robot2Queue = new LinkedList<>();
        int destination = size - 1;
        boolean[][] visit = new boolean[size][size];
        visit[0][0] = true;
        visit[0][1] = true;
        robot2Queue.offer(new Robot2(0, 0, 0, 1, 0, visit));
        while (true) {
            Robot2 robot2 = robot2Queue.poll();
            robot2.sort();
            int X1 = robot2.x1;
            int Y1 = robot2.y1;
            int X2 = robot2.x2;
            int Y2 = robot2.y2;
            int moves = robot2.moves;
            if ((X1 == destination && Y1 == destination) || (X2 == destination && Y2 == destination)) {
                return moves;
            }
            boolean[][] VISIT = robot2.visit;
            boolean[][] tmpVisit = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    tmpVisit[i][j] = VISIT[i][j];
                }
            }
            //움직임
            //1.상우하좌
            for (int i = 0; i < 4; i++) {
                int XX1 = X1 + dx[i];
                int YY1 = Y1 + dy[i];
                int XX2 = X2 + dx[i];
                int YY2 = Y2 + dy[i];
                if (innerRange(XX1, YY1, XX2, YY2) && board[XX1][YY1] != 1 && board[XX2][YY2] != 1 && (!tmpVisit[XX1][YY1] || !tmpVisit[XX2][YY2])) {
                    tmpVisit[XX1][YY1] = true;
                    tmpVisit[XX2][YY2] = true;
                    robot2Queue.offer(new Robot2(XX1, YY1, XX2, YY2, moves + 1, tmpVisit));
                    if (X1 == X2) {
                        if (i == 0) {
                            tmpVisit[XX1][YY1] = false;
                            tmpVisit[XX2][YY2] = false;
                        } else if (i == 1) {
                            tmpVisit[XX2][YY2] = false;
                        } else if (i == 2) {
                            tmpVisit[XX1][YY1] = false;
                            tmpVisit[XX2][YY2] = false;
                        } else {
                            tmpVisit[XX1][YY1] = false;
                        }
                    } else if (Y1 == Y2) {
                        if (i == 0) {
                            tmpVisit[XX1][YY1] = false;
                        } else if (i == 1) {
                            tmpVisit[XX1][YY1] = false;
                            tmpVisit[XX2][YY2] = false;
                        } else if (i == 2) {
                            tmpVisit[XX2][YY2] = false;
                        } else {
                            tmpVisit[XX1][YY1] = false;
                            tmpVisit[XX2][YY2] = false;
                        }
                    }
                }
            }

            //대각선 움직임
            if (X1 == X2) { // ㅡ모양
                int XX1 = X1 - 1;
                int YY1 = Y1;
                int XX2 = X2 - 1;
                int YY2 = Y2;
                if (innerRange(XX1, YY1, XX2, YY2) && board[XX1][YY1] != 1 && board[XX2][YY2] != 1) {
                    if (!tmpVisit[X2 - 1][Y2 - 1]) {
                        tmpVisit[X2 - 1][Y2 - 1] = true;
                        robot2Queue.offer(new Robot2(X1, Y1, X2 - 1, Y2 - 1, moves + 1, tmpVisit));
                        tmpVisit[X2 - 1][Y2 - 1] = false;
                    }
                    if (!tmpVisit[X1 - 1][Y1 + 1]) {
                        tmpVisit[X1 - 1][Y1 + 1] = true;
                        robot2Queue.offer(new Robot2(X1 - 1, Y1 + 1, X2, Y2, moves + 1, tmpVisit));
                        tmpVisit[X1 - 1][Y1 + 1] = false;
                    }
                }
                XX1 = X1 + 1;
                XX2 = X2 + 1;
                if (innerRange(XX1, YY1, XX2, YY2) && board[XX1][YY1] != 1 && board[XX2][YY2] != 1) {
                    if (!tmpVisit[X2 + 1][Y2 - 1]) {
                        tmpVisit[X2 + 1][Y2 - 1] = true;
                        robot2Queue.offer(new Robot2(X1, Y1, X2 + 1, Y2 - 1, moves + 1, tmpVisit));
                        tmpVisit[X2 + 1][Y2 - 1] = false;
                    }
                    if (!tmpVisit[X1 + 1][Y1 + 1]) {
                        tmpVisit[X1 + 1][Y1 + 1] = true;
                        robot2Queue.offer(new Robot2(X1 + 1, Y1 + 1, X2, Y2, moves + 1, tmpVisit));
                        tmpVisit[X1 + 1][Y1 + 1] = false;
                    }
                }
            } else { // ㅣ모양
                int YY = Y1 - 1;
                if (innerRange(X1, YY, X2, YY) && board[X1][YY] != 1 && board[X2][YY] != 1) { //왼쪽으로
                    if (!tmpVisit[X2 - 1][Y2 - 1]) {
                        tmpVisit[X2 - 1][Y2 - 1] = true;
                        robot2Queue.offer(new Robot2(X1, Y1, X2 - 1, Y2 - 1, moves + 1, tmpVisit));
                        tmpVisit[X2 - 1][Y2 - 1] = false;
                    }
                    if (!tmpVisit[X1 + 1][Y1 - 1]) {
                        tmpVisit[X1 + 1][Y1 - 1] = true;
                        robot2Queue.offer(new Robot2(X1 + 1, Y1 - 1, X2, Y2, moves + 1, tmpVisit));
                        tmpVisit[X1 + 1][Y1 - 1] = false;
                    }
                }
                YY = Y1 + 1;
                if (innerRange(X1, YY, X2, YY) && board[X1][YY] != 1 && board[X2][YY] != 1) { //오른쪽으로
                    if (!tmpVisit[X2 - 1][Y2 + 1]) {
                        tmpVisit[X2 - 1][Y2 + 1] = true;
                        robot2Queue.offer(new Robot2(X1, Y1, X2 - 1, Y2 + 1, moves + 1, tmpVisit));
                        tmpVisit[X2 - 1][Y2 + 1] = false;
                    }
                    if (!tmpVisit[X1 + 1][Y1 + 1]) {
                        tmpVisit[X1 + 1][Y1 + 1] = true;
                        robot2Queue.offer(new Robot2(X1 + 1, Y1 + 1, X2, Y2, moves + 1, tmpVisit));
                        tmpVisit[X1 + 1][Y1 + 1] = false;
                    }
                }
            }
        }
    }

    private static boolean innerRange(int a, int b, int c, int d) {
        if (a >= 0 && a < size && b >= 0 && b < size && c >= 0 && c < size && d >= 0 && d < size) {
            return true;
        }
        return false;
    }
}

class Robot2 {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int moves;
    public boolean[][] visit;

    Robot2(int x1, int y1, int x2, int y2, int moves, boolean[][] visit) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.moves = moves;
        this.visit = visit;
    }

    public void sort() { //x1,y1이 왼쪽 혹은 위쪽게 되게
        if (this.x1 == this.x2) { // ㅡ모양
            if (this.y1 > this.y2) {
                int tmp = this.y1;
                this.y1 = this.y2;
                this.y2 = tmp;
            }
        } else if (this.y1 == this.y2) { // l 모양
            if (this.x1 > this.x2) {
                int tmp = this.x1;
                this.x1 = this.x2;
                this.x2 = tmp;
            }
        }
    }
}