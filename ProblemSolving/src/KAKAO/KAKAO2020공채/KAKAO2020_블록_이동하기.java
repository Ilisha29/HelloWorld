package KAKAO.KAKAO2020공채;

import java.util.LinkedList;
import java.util.Queue;

// 22 : 50
public class KAKAO2020_블록_이동하기 {
    static int N;
    static int answer;
    static Queue<Robot> robotQueue;
    static Queue<boolean[][]> checkQueue;
    static int destination;
    static int[] mode1X1 = {-1, 0, 1, 0}; // 상우하좌 X
    static int[] mode1Y1 = {0, 1, 0, -1}; // 상우하좌 Y

    /*public static void main(String[] args) {
        int[][] tmpboard = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        N = tmpboard.length;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = tmpboard[i][j];
            }
        }
        answer = 0;
        robotQueue = new LinkedList<>();
        robotQueue.offer(new Robot());
        checkQueue = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        check[0][0] = true;
        check[0][1] = true;
        checkQueue.offer(check);
        destination = N - 1;
        //여기까지 초기화*/
    public static void main(String[] args) {
        int[][] tmpboard = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(tmpboard));
    }
    public static int solution(int[][] board) {
        N = board.length;
        answer = 0;
        robotQueue = new LinkedList<>();
        robotQueue.offer(new Robot());
        checkQueue = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        check[0][0] = true;
        check[0][1] = true;
        checkQueue.offer(check);
        destination = N - 1;
        //여기까지 초기화
        while (!robotQueue.isEmpty()) {
            Robot robot = robotQueue.poll();
            if ((robot.x1 == destination && robot.y1 == destination) || (robot.x2 == destination && robot.y2 == destination)) {
                answer = robot.moveNum;
                break;
            }
            boolean[][] checkMap = checkQueue.poll();
            boolean[][] tmpCheck = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmpCheck[j][k] = checkMap[j][k];
                }
            }

            //상우하좌
            for (int i = 0; i < 4; i++) {
                int X1 = robot.x1 + mode1X1[i];
                int Y1 = robot.y1 + mode1Y1[i];
                int X2 = robot.x2 + mode1X1[i];
                int Y2 = robot.y2 + mode1Y1[i];
                int MoveNum = robot.moveNum + 1;

                if (innerBoundary(X1) && innerBoundary(Y1) && innerBoundary(X2) && innerBoundary(Y2) && board[X1][Y1] == 0 && board[X2][Y2] == 0 && (!tmpCheck[X1][Y1] || !tmpCheck[X2][Y2])) {
                    boolean[][] tmpCheck2 = new boolean[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            tmpCheck2[j][k] = tmpCheck[j][k];
                        }
                    }
                    tmpCheck2[X1][Y1] = true;
                    tmpCheck2[X2][Y2] = true;
                    checkQueue.offer(tmpCheck2);
                    robotQueue.offer(new Robot(X1, Y1, X2, Y2, MoveNum));
                }
            }

            // ㅡ모양 회전
            if (robot.x1 == robot.x2) {
                int X1 = robot.x1;
                int X2 = robot.x2;
                int Y1 = robot.y1 < robot.y2 ? robot.y1 : robot.y2; //좌
                int Y2 = robot.y1 > robot.y2 ? robot.y1 : robot.y2; //우
                int MoveNum = robot.moveNum + 1;
                if (innerBoundary(X1 - 1) && innerBoundary(X2 - 1) && innerBoundary(Y1) && innerBoundary(Y2) && board[X1 - 1][Y1] == 0 && board[X2 - 1][Y2] == 0) {
                    boolean[][] tmpCheck2 = new boolean[N][N];
                    boolean[][] tmpCheck3 = new boolean[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            tmpCheck2[j][k] = tmpCheck[j][k];
                            tmpCheck3[j][k] = tmpCheck[j][k];
                        }
                    }
                    if (!tmpCheck2[X2 - 1][Y2 - 1]) {
                        tmpCheck2[X2 - 1][Y2 - 1] = true;
                        checkQueue.offer(tmpCheck2);
                        robotQueue.offer(new Robot(X1, Y1, X2 - 1, Y2 - 1, MoveNum));
                    }
                    if (!tmpCheck3[X1 - 1][Y1 + 1]) {
                        tmpCheck3[X2 - 1][Y2 - 1] = true;
                        checkQueue.offer(tmpCheck3);
                        robotQueue.offer(new Robot(X1 - 1, Y1 + 1, X2, Y2, MoveNum));
                    }
                }
                if (innerBoundary(X1 + 1) && innerBoundary(X2 + 1) && innerBoundary(Y1) && innerBoundary(Y2) && board[X1 + 1][Y1] == 0 && board[X2 + 1][Y2] == 0) {
                    boolean[][] tmpCheck2 = new boolean[N][N];
                    boolean[][] tmpCheck3 = new boolean[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            tmpCheck2[j][k] = tmpCheck[j][k];
                            tmpCheck3[j][k] = tmpCheck[j][k];
                        }
                    }
                    if (!tmpCheck2[X2 + 1][Y2 - 1]) {
                        tmpCheck2[X2 + 1][Y2 - 1] = true;
                        checkQueue.offer(tmpCheck2);
                        robotQueue.offer(new Robot(X1, Y1, X2 + 1, Y2 - 1, MoveNum));
                    }
                    if (!tmpCheck3[X1 + 1][Y1 + 1]) {
                        tmpCheck3[X1 + 1][Y1 + 1] = true;
                        checkQueue.offer(tmpCheck3);
                        robotQueue.offer(new Robot(X1 + 1, Y1 + 1, X2, Y2, MoveNum));
                    }

                }
            }
            // l모양 회전
            else {
                int Y1 = robot.y1;
                int Y2 = robot.y2;
                int X1 = robot.x1 < robot.x2 ? robot.x1 : robot.x2;
                int X2 = robot.x1 > robot.x2 ? robot.x1 : robot.x2;
                int MoveNum = robot.moveNum + 1;
                if (innerBoundary(X1) && innerBoundary(X2) && innerBoundary(Y1 - 1) && innerBoundary(Y2 - 1) && board[X1][Y1 - 1] == 0 && board[X2][Y2 - 1] == 0) {
                    boolean[][] tmpCheck2 = new boolean[N][N];
                    boolean[][] tmpCheck3 = new boolean[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            tmpCheck2[j][k] = tmpCheck[j][k];
                            tmpCheck3[j][k] = tmpCheck[j][k];
                        }
                    }
                    if (!tmpCheck2[X2 - 1][Y2 - 1]) {
                        tmpCheck2[X2 - 1][Y2 - 1] = true;
                        checkQueue.offer(tmpCheck2);
                        robotQueue.offer(new Robot(X1, Y1, X2 - 1, Y2 - 1, MoveNum));
                    }
                    if (!tmpCheck3[X1 + 1][Y1 - 1]) {
                        tmpCheck3[X1 + 1][Y1 - 1] = true;
                        checkQueue.offer(tmpCheck3);
                        robotQueue.offer(new Robot(X1 + 1, Y1 - 1, X2, Y2, MoveNum));
                    }
                }
                if (innerBoundary(X1) && innerBoundary(X2) && innerBoundary(Y1 + 1) && innerBoundary(Y2 + 1) && board[X1][Y1 + 1] == 0 && board[X2][Y2 + 1] == 0) {
                    boolean[][] tmpCheck2 = new boolean[N][N];
                    boolean[][] tmpCheck3 = new boolean[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            tmpCheck2[j][k] = tmpCheck[j][k];
                            tmpCheck3[j][k] = tmpCheck[j][k];
                        }
                    }
                    if (!tmpCheck2[X2 - 1][Y2 + 1]) {
                        tmpCheck2[X2 - 1][Y2 + 1] = true;
                        checkQueue.offer(tmpCheck2);
                        robotQueue.offer(new Robot(X1, Y1, X2 - 1, Y2 + 1, MoveNum));
                    }
                    if (!tmpCheck3[X1 + 1][Y1 + 1]) {
                        tmpCheck3[X1 + 1][Y1 + 1] = true;
                        checkQueue.offer(tmpCheck3);
                        robotQueue.offer(new Robot(X1 + 1, Y1 + 1, X2, Y2, MoveNum));
                    }
                }
            }
        }
        return answer;
    }

    private static boolean innerBoundary(int x1) {
        if (x1 >= 0 && x1 < N) {
            return true;
        }
        return false;
    }
}

class Robot {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int moveNum;

    public Robot() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 1;
        this.moveNum = 0;
    }

    public Robot(int x1, int y1, int x2, int y2, int moveNum) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.moveNum = moveNum;
    }
}
// 23 : 45 구현 완료