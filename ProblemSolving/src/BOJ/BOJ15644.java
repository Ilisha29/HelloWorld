package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14:40 start
public class BOJ15644 {
    static Queue<String[][]> mapQueue;
    static Queue<Integer> deep;
    static Queue<ArrayList<String>> directionArrayList;
    static int row;
    static int col;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[] stringAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        row = Integer.parseInt(stringTokenizer.nextToken());
        col = Integer.parseInt(stringTokenizer.nextToken());
        String[][] map = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = strings[j];
            }
        }
        int answer = -1;
        mapQueue = new LinkedList<>();
        deep = new LinkedList<>();
        directionArrayList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        mapQueue.offer(map);
        deep.offer(0);
        directionArrayList.offer(arrayList);
        while (!mapQueue.isEmpty()) {
            String[][] copyMap = mapQueue.poll();
            boolean isRed = false;
            boolean isBlue = false;
            int redX = 0;
            int redY = 0;
            int blueX = 0;
            int blueY = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (copyMap[i][j].equals("R")) {
                        redX = i;
                        redY = j;
                        isRed = true;
                    }
                    if (copyMap[i][j].equals("B")) {
                        blueX = i;
                        blueY = j;
                        isBlue = true;
                    }
                }
            }
            int tmpDeep = deep.poll();
            ArrayList<String> copyArrayList = directionArrayList.poll();
            //초기화

            if (tmpDeep > 10) break;
            if (!isRed && isBlue) { // 빨간공만 탈출
                answer = tmpDeep;
                stringAnswer = new String[answer];
                for (int i = 0; i < stringAnswer.length; i++) {
                    stringAnswer[i] = copyArrayList.get(i);
                }
                break;
            } else if (!isRed && !isBlue) continue; // 둘다 없음
            else if (isRed && !isBlue) continue; // 파란공만 탈출
            //탈출조건

            for (int i = 0; i < 4; i++) {
                int movedRedX = redX + dx[i];
                int movedRedY = redY + dy[i];
                int movedBlueX = blueX + dx[i];
                int movedBlueY = blueY + dy[i];
                if ((movedRedX > 0 && movedRedX < row - 1 && movedRedY > 0 && movedRedY < col - 1) || (movedBlueX > 0 && movedBlueX < row - 1 && movedBlueY > 0 && movedBlueY < col - 1)) {
                    if (copyMap[movedRedX][movedRedY].equals(".") || copyMap[movedRedX][movedRedY].equals("O") || copyMap[movedBlueX][movedBlueY].equals(".") || copyMap[movedBlueX][movedBlueY].equals("O")) {
                        String[][] tmpMap = new String[row][col];
                        for (int m = 0; m < row; m++) {
                            for (int n = 0; n < col; n++) {
                                tmpMap[m][n] = copyMap[m][n];
                            }
                        }
                        sendArray(tmpMap, i, redX, redY, blueX, blueY);
                        ArrayList<String> tmpArrayList = new ArrayList<>();
                        for (int m = 0; m < copyArrayList.size(); m++) {
                            tmpArrayList.add(copyArrayList.get(m));
                        }
                        if (i == 0) tmpArrayList.add("U");
                        else if (i == 1) tmpArrayList.add("R");
                        else if (i == 2) tmpArrayList.add("D");
                        else if (i == 3) tmpArrayList.add("L");
                        mapQueue.offer(tmpMap);
                        directionArrayList.offer(tmpArrayList);
                        deep.offer(tmpDeep + 1);
                    }
                }
            }
            //이동
        }
        System.out.println(answer);
        if (stringAnswer != null) {
            for (int i = 0; i < stringAnswer.length; i++) {
                System.out.print(stringAnswer[i]);
            }
        }
        bufferedReader.close();
    }

    private static void sendArray(String[][] tmpMap, int direction, int redX, int redY, int blueX, int blueY) {
        if (direction == 0) { //위
            String[] stringRed = new String[row];
            String[] stringBlue = new String[row];
            for (int i = 0; i < row; i++) {
                stringRed[i] = tmpMap[i][redY];
            }
            move(stringRed, tmpMap, redY, direction);
            for (int i = 0; i < row; i++) {
                stringBlue[i] = tmpMap[i][blueY];
            }
            move(stringBlue, tmpMap, blueY, direction);
        }
        if (direction == 1) { //오른쪽
            String[] stringRed = new String[col];
            String[] stringBlue = new String[col];
            for (int i = 0; i < col; i++) {
                stringRed[i] = tmpMap[redX][col - i - 1];
            }
            move(stringRed, tmpMap, redX, direction);

            for (int i = 0; i < col; i++) {
                stringBlue[i] = tmpMap[blueX][col - i - 1];
            }
            move(stringBlue, tmpMap, blueX, direction);
        }
        if (direction == 2) { //아래
            String[] stringRed = new String[row];
            String[] stringBlue = new String[row];
            for (int i = 0; i < row; i++) {
                stringRed[i] = tmpMap[row - 1 - i][redY];
            }
            move(stringRed, tmpMap, redY, direction);

            for (int i = 0; i < row; i++) {
                stringBlue[i] = tmpMap[row - 1 - i][blueY];
            }
            move(stringBlue, tmpMap, blueY, direction);
        }
        if (direction == 3) { //왼쪽
            String[] stringRed = new String[col];
            String[] stringBlue = new String[col];
            for (int i = 0; i < col; i++) {
                stringRed[i] = tmpMap[redX][i];
            }
            move(stringRed, tmpMap, redX, direction);

            for (int i = 0; i < col; i++) {
                stringBlue[i] = tmpMap[blueX][i];
            }
            move(stringBlue, tmpMap, blueX, direction);
        }
    }

    private static void move(String[] strings, String[][] tmpMap, int index, int direction) {
        for (int i = 1; i < strings.length - 1; i++) {
            if (strings[i].equals("R") || strings[i].equals("B")) {
                for (int j = i - 1; j >= 0; j--) {
                    if (strings[j].equals("O")) {
                        strings[i] = ".";
                        break;
                    }
                    if (strings[j].equals("#") || strings[j].equals("R") || strings[j].equals("B")) {
                        String tmp = strings[i];
                        strings[i] = ".";
                        strings[j + 1] = tmp;
                        break;
                    }
                }
            }
        }
        if (direction == 0) {
            for (int i = 0; i < strings.length; i++) {
                tmpMap[i][index] = strings[i];
            }
        }
        if (direction == 1) {
            for (int i = 0; i < strings.length; i++) {
                tmpMap[index][col - 1 - i] = strings[i];
            }
        }
        if (direction == 2) {
            for (int i = 0; i < strings.length; i++) {
                tmpMap[row - 1 - i][index] = strings[i];
            }
        }
        if (direction == 3) {
            for (int i = 0; i < strings.length; i++) {
                tmpMap[index][i] = strings[i];
            }
        }
    }
}
// 16 : 48 end