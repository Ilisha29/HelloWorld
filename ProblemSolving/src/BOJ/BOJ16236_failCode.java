package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12 : 05 start
public class BOJ16236_failCode {
    static int[][] map;
    static int babySharkSize;
    static int length;
    static int SHARKX;
    static int SHARKY;
    static int FISHX;
    static int FISHY;
    static int answer;
    static int ateFishNum;
    static int[][] lengthMap;
    static int I;
    static int J;
    static Queue<Integer> queueX;
    static Queue<Integer> queueY;
    static Queue<Integer> queueTmpLength;
    static Queue<boolean[][]> queueCheck;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        //=======================입력 끝====================

        answer = 0;
        babySharkSize = 2;
        ateFishNum = 0;
        while (true) {
            int fishNum = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] >= 1 && map[i][j] < babySharkSize) {
                        fishNum++;
                    }
                    if (map[i][j] == 9) {
                        SHARKX = i;
                        SHARKY = j;
                    }
                }
            }
            if (fishNum == 0) {
                break;
            }
            //============조건 1 : 탈출 조건 마마 콜 =========

            /*놓친부분1*/
            length = (size) * (size); //직각으로 가는건 최대경로가 아니다. 완전 돌아가는 경우를 고려하기
            /*놓친부분1*/
            FISHX = size - 1;
            FISHY = size - 1;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] >= 1 && map[i][j] < babySharkSize) {
                        boolean[][] check = new boolean[size][size];
                        lengthMap = new int[size][size];
                        
                        for (int k = 0; k < lengthMap.length; k++) {
                            for (int l = 0; l < lengthMap.length; l++) {
                                lengthMap[k][l] = size * size - 1;
                            }
                        }
                        int tmpLength = 0;
                        I = i;
                        J = j;
                        queueX = new LinkedList<>();
                        queueY = new LinkedList<>();
                        queueTmpLength = new LinkedList<>();
                        queueCheck = new LinkedList<>();
                        //findLength(SHARKX, SHARKY, tmpLength, check);
                        BFS(SHARKX, SHARKY, tmpLength, check);
                    }
                }
            }
            map[FISHX][FISHY] = 9;
            map[SHARKX][SHARKY] = 0;
            SHARKX = FISHX;
            SHARKY = FISHY;
            answer += length;
            ateFishNum++;
            if (ateFishNum == babySharkSize) {
                babySharkSize++;
                ateFishNum = 0;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

/*
    private static void findLength(int sharkX, int sharkY, int tmpLength, boolean[][] check) {
        if (sharkX == I && sharkY == J) {
            if (tmpLength < length) {
                length = tmpLength;
                FISHX = I;
                FISHY = J;
            }
            return;
        }
        if (tmpLength >= length) {
            return; // 시간 단축
        }
        if (check[sharkX][sharkY]) {
            return;
        }
        check[sharkX][sharkY] = true;
        if (tmpLength > lengthMap[sharkX][sharkY]) {
            return;
        }
        if (tmpLength < lengthMap[sharkX][sharkY]) {
            lengthMap[sharkX][sharkY] = tmpLength;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int X = sharkX + dx[i];
            int Y = sharkY + dy[i];
            if (X >= 0 && X < map.length && Y >= 0 && Y < map.length && map[X][Y] <= babySharkSize && !check[X][Y]) {
                findLength(X, Y, tmpLength + 1, check);
                */
    /*놓친부분2*//*

                check[X][Y] = false; //ㅠㅠ 이부분 초기화 해줘야된다.... true값이 였었다.......... 안그럼 같은 깊이에서 다른 깊이에서 영향 받은 boolean값이 넘어옴 초기화 제대로
                */
    /*놓친부분2*//*

            }
        }
    }

*/

    private static void BFS(int sharkX, int sharkY, int tmpLength, boolean[][] check) {
        queueX.offer(sharkX);
        queueY.offer(sharkY);
        queueTmpLength.offer(tmpLength);
        queueCheck.offer(check);
        while (!queueCheck.isEmpty()) {
            int X = queueX.poll();
            int Y = queueY.poll();
            int tmplength = queueTmpLength.poll();
            boolean[][] tmpCheck = queueCheck.poll();
            if (X == I && Y == J) {
                if (tmplength < length) {
                    length = tmplength;
                    FISHX = X;
                    FISHY = Y;
                }
                return;
            }
            if (tmplength >= length) continue;
            if (tmpCheck[X][Y]) continue;
            if (tmplength > lengthMap[X][Y]) continue;
            if (tmplength < lengthMap[X][Y]) lengthMap[X][Y] = tmplength;
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int X2 = X + dx[i];
                int Y2 = Y + dy[i];
                if (X2 >= 0 && X2 < map.length && Y2 >= 0 && Y2 < map.length && map[X2][Y2] <= babySharkSize && !tmpCheck[X2][Y2]) {
                    queueX.offer(X2);
                    queueY.offer(Y2);
                    queueCheck.offer(tmpCheck);
                    queueTmpLength.offer(tmplength + 1);
                    check[X][Y] = false;
                }
            }
        }
    }
}
// 17 : 08 end