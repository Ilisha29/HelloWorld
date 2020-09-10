package KAKAO.KAKAO공채연습._2020;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        /*int[][] visit = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        visit[0][0] = 1;*/
        boolean[][] visit = new boolean[size][size];
        visit[0][0] = true;
        Queue<Robot> robots = new LinkedList<>();
        robots.add(new Robot(0, 0, 1, 0, visit));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!robots.isEmpty()) {
            Robot polledRobot = robots.poll();
            int x = polledRobot.x;
            int y = polledRobot.y;
            int[] anotherXY = new int[2];
            calculateOtherLocation(polledRobot, anotherXY);
            printMap(x, y, anotherXY, board);
            if ((polledRobot.x == size - 1 && polledRobot.y == size - 1) || (anotherXY[0] == size - 1 && anotherXY[1] == size - 1)) {
                answer = polledRobot.answer;
                break;
            }
            for (int i = 0; i < 4; i++) { //상하좌우
                int X = x + dx[i];
                int X2 = anotherXY[0] + dx[i];
                int Y = y + dy[i];
                int Y2 = anotherXY[1] + dy[i];
                if (isCanMove(X, X2, Y, Y2, board, polledRobot.visit, polledRobot.answer)) {
                    boolean[][] VISIT = makeArray(polledRobot.visit);
                    VISIT[X][Y] = true;
                    robots.add(new Robot(X, Y, polledRobot.direction, polledRobot.answer + 1, VISIT));
                }
            }
            if (polledRobot.direction == 0) {
                directionUp(polledRobot, board, robots, polledRobot.visit);
            } else if (polledRobot.direction == 1) {
                directionRight(polledRobot, board, robots, polledRobot.visit);
            } else if (polledRobot.direction == 2) {
                directionDown(polledRobot, board, robots, polledRobot.visit);
            } else {
                directionLeft(polledRobot, board, robots, polledRobot.visit);
            }
        }
        return answer;
    }

    private static boolean[][] makeArray(boolean[][] visit) {
        boolean[][] tmpVisit = new boolean[visit.length][visit.length];
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit.length; j++) {
                tmpVisit[i][j] = visit[i][j];
            }
        }
        return tmpVisit;
    }

    private static void printMap(int x, int y, int[] anotherXY, int[][] board) {
        int[][] tmp = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        tmp[x][y] = 2;
        tmp[anotherXY[0]][anotherXY[1]] = 2;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================");
    }


    private static void directionLeft(Robot polledRobot, int[][] board, Queue<Robot> robots, boolean[][] visit) {
        int x = polledRobot.x;
        int y = polledRobot.y;
        int move = polledRobot.answer;
        if (x - 1 >= 0 && board[x - 1][y] == 0 && board[x - 1][y - 1] == 0) { //checkLeft
            if (!visit[x - 1][y]) {
                robots.add(new Robot(x, y, 0, move + 1, visit));
            }
            if (!visit[x - 1][y - 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x - 1][y - 1] = true;
                robots.add(new Robot(x - 1, y - 1, 2, move + 1, VISIT));
            }
        }
        if (x + 1 <= board.length - 1 && board[x + 1][y] == 0 && board[x + 1][y - 1] == 0) { //checkRight
            if (!visit[x + 1][y]) {
                robots.add(new Robot(x, y, 2, move + 1, visit));
            }
            if (!visit[x + 1][y - 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x + 1][y - 1] = true;
                robots.add(new Robot(x + 1, y - 1, 0, move + 1, VISIT));
            }
        }
    }

    private static void directionDown(Robot polledRobot, int[][] board, Queue<Robot> robots, boolean[][] visit) {
        int x = polledRobot.x;
        int y = polledRobot.y;
        int move = polledRobot.answer;
        if (y - 1 >= 0 && board[x][y - 1] == 0 && board[x + 1][y - 1] == 0) { //checkLeft
            if (!visit[x][y - 1]) {
                robots.add(new Robot(x, y, 3, move + 1, visit));
            }
            if (!visit[x + 1][y - 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x + 1][y - 1] = true;
                robots.add(new Robot(x + 1, y - 1, 1, move + 1, VISIT));

            }
        }
        if (y + 1 <= board.length - 1 && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0) { //checkRight
            if (!visit[x][y + 1]) {
                robots.add(new Robot(x, y, 1, move + 1, visit));
            }
            if (!visit[x + 1][y + 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x + 1][y + 1] = true;
                robots.add(new Robot(x + 1, y + 1, 3, move + 1, VISIT));
            }
        }
    }

    private static void directionRight(Robot polledRobot, int[][] board, Queue<Robot> robots, boolean[][] visit) {
        int x = polledRobot.x;
        int y = polledRobot.y;
        int move = polledRobot.answer;
        if (x - 1 >= 0 && board[x - 1][y] == 0 && board[x - 1][y + 1] == 0) { //checkLeft
            if (!visit[x - 1][y]) {
                robots.add(new Robot(x, y, 0, move + 1, visit));
            }
            if (!visit[x - 1][y + 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x - 1][y + 1] = true;
                robots.add(new Robot(x - 1, y + 1, 2, move + 1, VISIT));
            }
        }
        if (x + 1 <= board.length - 1 && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) { //checkRight
            if (!visit[x + 1][y]) {
                robots.add(new Robot(x, y, 2, move + 1, visit));
            }
            if (!visit[x + 1][y + 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x + 1][y + 1] = true;
                robots.add(new Robot(x + 1, y + 1, 0, move + 1, VISIT));

            }
        }
    }

    private static void directionUp(Robot polledRobot, int[][] board, Queue<Robot> robots, boolean[][] visit) {
        int x = polledRobot.x;
        int y = polledRobot.y;
        int x2 = x - 1;
        int move = polledRobot.answer;
        if (y - 1 >= 0 && board[x][y - 1] == 0 && board[x2][y - 1] == 0) { //checkLeft
            if (!visit[x - 1][y - 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x - 1][y - 1] = true;
                robots.add(new Robot(x - 1, y - 1, 1, move + 1, VISIT));

            }
            if (!visit[x][y - 1]) {
                robots.add(new Robot(x, y, 3, move + 1, visit));
            }
        }
        if (y + 1 <= board.length - 1 && board[x - 1][y + 1] == 0 && board[x][y + 1] == 0) { //checkRight
            if (!visit[x - 1][y + 1]) {
                boolean[][] VISIT = makeArray(polledRobot.visit);
                VISIT[x - 1][y + 1] = true;
                robots.add(new Robot(x - 1, y + 1, 3, move + 1, VISIT));
            }
            if (!visit[x][y + 1]) {
                robots.add(new Robot(x, y, 1, move + 1, visit));
            }
        }
    }

    private static boolean isCanMove(int x, int x2, int y, int y2, int[][] board, boolean[][] visit, int tmpAnswer) {
        int size = board.length;
        if (!(x >= 0 && x <= size - 1 && x2 >= 0 && x2 <= size - 1 && y >= 0 && y <= size - 1 && y2 >= 0 && y2 <= size - 1)) {
            return false;
        }
        if (board[x][y] == 1 || board[x2][y2] == 1) {
            return false;
        }
        if (!visit[x][y]) {
            return false;
        }
        return true;
    }

    private static void calculateOtherLocation(Robot polledRobot, int[] anotherXY) {
        if (polledRobot.direction == 0) {
            anotherXY[0] = polledRobot.x - 1;
            anotherXY[1] = polledRobot.y;
        } else if (polledRobot.direction == 1) {
            anotherXY[0] = polledRobot.x;
            anotherXY[1] = polledRobot.y + 1;
        } else if (polledRobot.direction == 2) {
            anotherXY[0] = polledRobot.x + 1;
            anotherXY[1] = polledRobot.y;
        } else {
            anotherXY[0] = polledRobot.x;
            anotherXY[1] = polledRobot.y - 1;
        }
    }
}

class Robot {
    int x;
    int y;
    int direction;
    int answer;
    boolean[][] visit;

    Robot(int x, int y, int direction, int answer, boolean[][] visit) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.answer = answer;
        this.visit = visit;
    }
}