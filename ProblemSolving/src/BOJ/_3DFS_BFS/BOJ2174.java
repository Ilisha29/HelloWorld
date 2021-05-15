package BOJ._3DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2174 {
    private static final String FIRST_ERROR_POSTFIX = " crashes into the wall";
    private static final String SECOND_ERROR_INFIX = " crashes into robot ";
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] AB = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = AB[0];
        int B = AB[1];
        int[][] map = new int[A][B];
        int[] NM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];
        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] inputN = bufferedReader.readLine().split(" ");
            char inputDirection = inputN[2].charAt(0);
            char directions;
            if (inputDirection == 'N') {
                directions = 'E';
            } else if (inputDirection == 'E') {
                directions = 'S';
            } else if (inputDirection == 'S') {
                directions = 'W';
            } else {
                directions = 'N';
            }
            map[Integer.parseInt(inputN[0]) - 1][Integer.parseInt(inputN[1]) - 1] = i + 1;
            robots.add(new Robot(i + 1, directions, Integer.parseInt(inputN[0]) - 1, Integer.parseInt(inputN[1]) - 1));
        }
        System.out.println(printAnswer(map, robots, M, bufferedReader));
        bufferedReader.close();
    }

    private static String printAnswer(int[][] map, ArrayList<Robot> robots, int M, BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < M; i++) {
            String[] inputM = bufferedReader.readLine().split(" ");
            Robot foundRobot = findRobotByNumber(Integer.parseInt(inputM[0]), robots);
            int rep = Integer.parseInt(inputM[2]);
            for (int j = 0; j < rep; j++) {
                if (inputM[1].equals("F")) {
                    int x = foundRobot.x;
                    int y = foundRobot.y;
                    int newX;
                    int newY;
                    if (foundRobot.direction == 'N') {
                        newX = x + dx[0];
                        newY = y + dy[0];
                    } else if (foundRobot.direction == 'E') {
                        newX = x + dx[1];
                        newY = y + dy[1];
                    } else if (foundRobot.direction == 'S') {
                        newX = x + dx[2];
                        newY = y + dy[2];
                    } else {
                        newX = x + dx[3];
                        newY = y + dy[3];
                    }
                    if (!(newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length)) {
                        return "Robot " + foundRobot.number + FIRST_ERROR_POSTFIX;
                    } else if (map[newX][newY] != 0) {
                        return "Robot " + foundRobot.number + SECOND_ERROR_INFIX + map[newX][newY];
                    } else {
                        map[x][y] = 0;
                        map[newX][newY] = foundRobot.number;
                        foundRobot.x = newX;
                        foundRobot.y = newY;
                    }
                } else if (inputM[1].equals("L")) {
                    if (foundRobot.direction == 'N') {
                        foundRobot.direction = 'W';
                    } else if (foundRobot.direction == 'E') {
                        foundRobot.direction = 'N';
                    } else if (foundRobot.direction == 'S') {
                        foundRobot.direction = 'E';
                    } else if (foundRobot.direction == 'W') {
                        foundRobot.direction = 'S';
                    }
                } else if (inputM[1].equals("R")) {
                    if (foundRobot.direction == 'N') {
                        foundRobot.direction = 'E';
                    } else if (foundRobot.direction == 'E') {
                        foundRobot.direction = 'S';
                    } else if (foundRobot.direction == 'S') {
                        foundRobot.direction = 'W';
                    } else if (foundRobot.direction == 'W') {
                        foundRobot.direction = 'N';
                    }
                }
            }
        }
        return "OK";
    }

    private static Robot findRobotByNumber(int parseInt, ArrayList<Robot> robots) {
        for (Robot robot : robots) {
            if (robot.number == parseInt) {
                return robot;
            }
        }
        return null;
    }
}

class Robot {
    int number;
    char direction;
    int x;
    int y;

    public Robot(int number, char direction, int x, int y) {
        this.number = number;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }
}
