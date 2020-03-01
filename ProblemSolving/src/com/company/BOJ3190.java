package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int[][] map;
    static int[] timeOrder;
    static String[] directionOrder;
    static int[][] directionMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size + 2][size + 2];
        directionMap = new int[size + 2][size + 2];
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                directionMap[i][j] = 4;
            }
        }
        for (int i = 0; i < map.length; i++) {
            map[0][i] = 2;
            map[map.length - 1][i] = 2;
            map[i][0] = 2;
            map[i][map.length - 1] = 2;
        }
        int appleRep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < appleRep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());
            map[X][Y] = 1;
        }
        /*
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        */
        int moveRep = Integer.parseInt(bufferedReader.readLine());
        timeOrder = new int[moveRep];
        directionOrder = new String[moveRep];
        for (int i = 0; i < moveRep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            timeOrder[i] = Integer.parseInt(stringTokenizer.nextToken());
            directionOrder[i] = stringTokenizer.nextToken();
        }
        /*
        System.out.println("====timeOrder======");
        for (int i = 0; i < timeOrder.length; i++) {
            System.out.print(timeOrder[i] + " ");
        }
        System.out.println("====timeOrder======");
        System.out.println("====directionOrder======");
        for (int i = 0; i < directionOrder.length; i++) {
            System.out.print(directionOrder[i] + " ");
        }
        System.out.println("====directionOrder======");
        */
        //여기까지 초기화 및 입력

        //gameStart
        int time = 0;
        int direction = 1;
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        int orderIndex = 0;
        int headX = 1;
        int headY = 1;
        int tailX = 1;
        int tailY = 1;
        map[headX][headY] = 3;  // 뱀은 3 벽은 2 사과는 1
        directionMap[1][1] = direction;
        while (true) {
            time++;
            headX += row[direction];
            headY += col[direction];
            if (map[headX][headY] == 2 || map[headX][headY] == 3) {
                break;
            }
            if (map[headX][headY] == 0) {
                map[tailX][tailY] = 0;
                if (directionMap[tailX][tailY] == 0) {
                    directionMap[tailX][tailY] = 4;
                    tailX += row[0];
                    tailY += col[0];
                } else if (directionMap[tailX][tailY] == 1) {
                    directionMap[tailX][tailY] = 4;
                    tailX += row[1];
                    tailY += col[1];
                } else if (directionMap[tailX][tailY] == 2) {
                    directionMap[tailX][tailY] = 4;
                    tailX += row[2];
                    tailY += col[2];
                } else {
                    directionMap[tailX][tailY] = 4;
                    tailX += row[3];
                    tailY += col[3];
                }
            }
            map[headX][headY] = 3;
            if (timeOrder[orderIndex] == time) {
                if (directionOrder[orderIndex].equals("L")) {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction--;
                    }
                } else if (directionOrder[orderIndex].equals("D")) {
                    if (direction == 3) {
                        direction = 0;
                    } else {
                        direction++;
                    }
                }
                if (orderIndex < timeOrder.length - 1) orderIndex++; //여기서 timeOrder 배열 초과
            }
            directionMap[headX][headY] = direction;
            //확인
            /*System.out.println("===========time : " + time + " ===========");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("=========================");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    System.out.print(directionMap[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            */
        }
        System.out.println(time);
        bufferedReader.close();
    }
}
