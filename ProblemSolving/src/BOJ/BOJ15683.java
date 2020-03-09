package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 04 : 20 start
public class BOJ15683 {
    static int[][] map;
    static int answer;
    static int[] cameraType;
    static int[] cameraDirection;
    static int[] cameraX;
    static int[] cameraY;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        answer = row * col;
        //=====================입력 끝 ================

        int cameraNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cameraNum++;
                }
            }
        }
        int index = -1;
        cameraType = new int[cameraNum];
        cameraDirection = new int[cameraNum];
        cameraX = new int[cameraNum];
        cameraY = new int[cameraNum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    index++;
                    cameraType[index] = map[i][j];
                    if (map[i][j] == 1) {
                        cameraDirection[index] = 4;
                    } else if (map[i][j] == 2) {
                        cameraDirection[index] = 2;
                    } else if (map[i][j] == 3) {
                        cameraDirection[index] = 4;
                    } else if (map[i][j] == 4) {
                        cameraDirection[index] = 4;
                    } else {
                        cameraDirection[index] = 1;
                    }
                    cameraX[index] = i;
                    cameraY[index] = j;
                    /*if (index < cameraNum - 2) {
                        index++;
                    }*/
                }
            }
        }
        int[] tmpCase = new int[cameraNum];
        cases(tmpCase, 0);

        System.out.println(answer);
        bufferedReader.close();
    }

    private static void cases(int[] tmpCase, int depth) {
        if (depth == tmpCase.length) {
            int[][] tmpMap = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < tmpCase.length; i++) {
                int x = cameraX[i];
                int y = cameraY[i];
                if (cameraType[i] == 1) {
                    if (tmpCase[i] == 1) { //위
                        for (int j = x; j >= 0; j--) {
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }
                    } else if (tmpCase[i] == 2) { //오른
                        for (int j = y; j < tmpMap[0].length; j++) {
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }

                        }
                    } else if (tmpCase[i] == 3) { //아래
                        for (int j = x; j < tmpMap.length; j++) {
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }
                    } else { //왼쪽
                        for (int j = y; j >= 0; j--) {
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }

                        }

                    }
                } else if (cameraType[i] == 2) {
                    if (tmpCase[i] == 1) {
                        for (int j = y; j < tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }
                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }
                    } else {
                        for (int j = x; j >= 0; j--) {
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }
                        for (int j = x; j < tmpMap.length; j++) {
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                    }
                } else if (cameraType[i] == 3) {
                    if (tmpCase[i] == 1) {  //위
                        for (int j = x; j >= 0; j--) {
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j < tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                    } else if (tmpCase[i] == 2) {
                        for (int j = y; j <= tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                        for (int j = x; j <= tmpMap.length; j++) { //아래
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                    } else if (tmpCase[i] == 3) {
                        for (int j = x; j <= tmpMap.length; j++) { //아래
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }
                    } else {
                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                        for (int j = x; j >= 0; j--) { //위
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                    }

                } else if (cameraType[i] == 4) {
                    if (tmpCase[i] == 1) {
                        for (int j = x; j >= 0; j--) { //위
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j < tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                        for (int j = x; j <= tmpMap.length; j++) { //아래
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                    } else if (tmpCase[i] == 2) {

                        for (int j = y; j < tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                        for (int j = x; j <= tmpMap.length; j++) { //아래
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                    } else if (tmpCase[i] == 3) {
                        for (int j = x; j >= 0; j--) { //위
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }


                        for (int j = x; j <= tmpMap.length; j++) { //아래
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                    } else {
                        for (int j = x; j >= 0; j--) { //위
                            if (tmpMap[j][y] == 6) {
                                break;
                            }
                            if (tmpMap[j][y] == 0) {
                                tmpMap[j][y] = 7;
                            }
                        }

                        for (int j = y; j < tmpMap[0].length; j++) { //오른
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                        for (int j = y; j >= 0; j--) { //왼
                            if (tmpMap[x][j] == 6) {
                                break;
                            }
                            if (tmpMap[x][j] == 0) {
                                tmpMap[x][j] = 7;
                            }
                        }

                    }
                } else {
                    for (int j = x; j >= 0; j--) { //위
                        if (tmpMap[j][y] == 6) {
                            break;
                        }
                        if (tmpMap[j][y] == 0) {
                            tmpMap[j][y] = 7;
                        }
                    }

                    for (int j = y; j <= tmpMap[0].length; j++) { //오른쪽
                        if (tmpMap[x][j] == 6) {
                            break;
                        }
                        if (tmpMap[x][j] == 0) {
                            tmpMap[x][j] = 7;
                        }
                    }

                    for (int j = x; j <= tmpMap.length; j++) { //아래
                        if (tmpMap[j][y] == 6) {
                            break;
                        }
                        if (tmpMap[j][y] == 0) {
                            tmpMap[j][y] = 7;
                        }
                    }

                    for (int j = y; j >= 0; j--) { //왼쪽
                        if (tmpMap[x][j] == 6) {
                            break;
                        }
                        if (tmpMap[x][j] == 0) {
                            tmpMap[x][j] = 7;
                        }
                    }
                }
            }
            int zeroNum = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (tmpMap[i][j] == 0) {
                        zeroNum++;
                    }
                }
            }
            answer = zeroNum < answer ? zeroNum : answer;
            return;
        }
        for (int i = 1; i <= cameraDirection[depth]; i++) {
            tmpCase[depth] = i;
            cases(tmpCase, depth + 1);
        }
    }
}
