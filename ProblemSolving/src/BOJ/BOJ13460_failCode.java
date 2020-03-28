package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16 : 45 start
public class BOJ13460_failCode {
    static Queue<String[][]> mapQueue;
    static Queue<Integer> deep;
    static int holeX;
    static int holeY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        String[][] map = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = strings[j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j].equals("O")) {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        int answer = -1;
        // 입력 끝
        mapQueue = new LinkedList<>();
        deep = new LinkedList<>();

        mapQueue.offer(map);
        deep.offer(0);

        while (!mapQueue.isEmpty()) {
            String[][] beforeMap = mapQueue.poll();
            int tmpDeep = deep.poll();
            if (tmpDeep >= 10) {
                break;
            }
            if (answerCheck(beforeMap)) {
                answer = tmpDeep + 1;
                System.out.println("답있다.");
                break;
            }
            //////////////////////


            //움직이기 가능파악
            int redX = 0;
            int redY = 0;
            int blueX = 0;
            int blueY = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (beforeMap[i][j].equals("R")) {
                        redX = i;
                        redY = j;
                    }
                    if (beforeMap[i][j].equals("B")) {
                        blueX = i;
                        blueY = j;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int redX2 = redX + dx[i];
                int redY2 = redY + dy[i];
                int blueX2 = blueX + dx[i];
                int blueY2 = blueY + dy[i];
                if (beforeMap[redX2][redY2].equals(".") || beforeMap[blueX2][blueY2].equals(".")) {
                    String[][] tmpMap = new String[row][col];
                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < col; k++) {
                            tmpMap[j][k] = beforeMap[j][k];
                        }
                    }
                    if (redX2 == blueX2) {
                        if (i == 1) {

                        } else if (i == 3) {

                        } else {
                            Move(tmpMap, i);
                        }
                    } else if (redY2 == blueY2) {
                        if (i == 0) {

                        } else if (i == 2) {

                        } else {
                            Move(tmpMap, i);
                        }
                    } else {
                        Move(tmpMap, i);
                    }
                    mapQueue.offer(tmpMap);
                    deep.offer(tmpDeep + 1);
                }
            }
        }

        String[][] tmpMap = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void Move(String[][] tmpMap, int direction) {
    }

    private static boolean answerCheck(String[][] beforeMap) {
        int redX = 0;
        int redY = 0;
        for (int i = 1; i < beforeMap.length - 1; i++) {
            for (int j = 1; j < beforeMap[0].length - 1; j++) {
                if (beforeMap[i][j].equals("R")) {
                    redX = i;
                    redY = j;
                    break;
                }
            }
        }

        if (redX == holeX || redY == holeY) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (redY == holeY) {
                if (redX > holeX) {
                    for (int i = holeX + 1; i < beforeMap.length - 1; i++) {
                        if (beforeMap[i][holeY].equals("#") || beforeMap[i][holeY].equals("B") || beforeMap[i][holeY].equals("R")) {
                            arrayList.add(beforeMap[i][holeY]);
                        }
                    }
                } else {
                    for (int i = holeX - 1; i > 0; i--) {
                        if (beforeMap[i][holeY].equals("#") || beforeMap[i][holeY].equals("B") || beforeMap[i][holeY].equals("R")) {
                            arrayList.add(beforeMap[i][holeY]);
                        }
                    }
                }
            } else if (redX == holeX) {
                if (redY > holeY) {
                    for (int i = holeY + 1; i < beforeMap[0].length - 1; i++) {
                        if (beforeMap[holeX][i].equals("#") || beforeMap[holeX][i].equals("B") || beforeMap[holeX][i].equals("R")) {
                            arrayList.add(beforeMap[holeX][i]);
                        }
                    }
                } else {
                    for (int i = holeY - 1; i > 0; i--) {
                        if (beforeMap[holeX][i].equals("#") || beforeMap[holeX][i].equals("B") || beforeMap[holeX][i].equals("R")) {
                            arrayList.add(beforeMap[holeX][i]);
                        }
                    }
                }
            }

            ArrayList<String> arrayList1 = new ArrayList<>();
            arrayList1.add(arrayList.get(0));
            for (int i = 1; i < arrayList.size(); i++) {
                if (!arrayList.get(i).equals(arrayList1.get(arrayList1.size() - 1))) {
                    arrayList1.add(arrayList.get(i));
                }
            }

            if (arrayList1.size() == 1) {
                return true;
            } else if (arrayList1.size() >= 2) {
                if (arrayList1.get(0).equals("R") && arrayList1.get(1).equals("#")) {
                    return true;
                }
            }
        }
        return false;
    }
}
// 17 : 05 pause
