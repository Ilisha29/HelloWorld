package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15684 {
    static ArrayList<Integer> x;
    static ArrayList<Integer> y;
    static boolean[][] ladderMap;
    static boolean[][] canPutLadderMap;
    static boolean[][] tmpLadderMap;
    static boolean[][] tmpCanPutLadderMap;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int col = Integer.parseInt(strings[0]) - 1;
        int N = Integer.parseInt(strings[1]);
        int row = Integer.parseInt(strings[2]);
        ladderMap = new boolean[row][col];
        for (int i = 0; i < N; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            ladderMap[Integer.parseInt(strings1[0]) - 1][Integer.parseInt(strings1[1]) - 1] = true;
        }
        answer = -1;
        //입력

        int originLadder = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ladderMap[i][j]) {
                    originLadder++;
                }
            }
        }
        int i = 0;
        canPutLadderMap = new boolean[row][col];
        if (col == 1) {
            for (int j = 0; j < row; j++) {
                if (ladderMap[j][0]) {
                    canPutLadderMap[j][0] = true;
                }
            }
        } else {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (ladderMap[j][k]) {
                        canPutLadderMap[j][k] = true;
                        if (k == 0) {
                            canPutLadderMap[j][k + 1] = true;
                        } else if (k == col - 1) {
                            canPutLadderMap[j][k - 1] = true;
                        } else {
                            canPutLadderMap[j][k - 1] = true;
                            canPutLadderMap[j][k + 1] = true;
                        }
                    }
                }
            } // false에 둘 수 있다.
        }
        x = new ArrayList<>();
        y = new ArrayList<>();
        int canPutLadder = 0;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (!canPutLadderMap[m][n]) {
                    x.add(m);
                    y.add(n);
                    canPutLadder++;
                }
            }
        }

        tmpLadderMap = new boolean[row][col];
        tmpCanPutLadderMap = new boolean[row][col];
        for (int a = 0; a < row; a++) {
            for (int m = 0; m < col; m++) {
                tmpLadderMap[a][m] = ladderMap[a][m];
                tmpCanPutLadderMap[a][m] = canPutLadderMap[a][m];
            }
        }

        while (i < 4) {
            if (i == 0) { //바로가능한지
                if (originLadder % 2 == 0) {
                    if (isAnswer(ladderMap)) {
                        answer = 0;
                        break;
                    }
                }
                i++;
            } else if (i == 1) { //1개추가
                if (i <= canPutLadder) {
                    if ((originLadder + i) % 2 == 0) {
                        //사다리두기
                        for (int j = 0; j < x.size(); j++) {
                            int[] array = {j};
                            putLadders(array, tmpLadderMap, tmpCanPutLadderMap);
                        }
                    }
                }
                i++;
            } else if (i == 2) {
                if (answer == -1) {
                    if (i <= canPutLadder) {
                        if ((originLadder + i) % 2 == 0) {
                            //사다리두기
                            for (int j = 0; j < x.size() - 1; j++) {
                                for (int k = j + 1; k < x.size(); k++) {
                                    int[] array = {j, k};
                                    putLadders(array, tmpLadderMap, tmpCanPutLadderMap);
                                }
                            }
                        }
                    }
                }
                i++;
            } else if (i == 3) {
                if (answer == -1) {
                    if (i <= canPutLadder) {
                        if ((originLadder + i) % 2 == 0) {
                            //사다리두기
                            for (int j = 0; j < x.size() - 2; j++) {
                                for (int k = j + 1; k < x.size() - 1; k++) {
                                    for (int l = k + 1; l < x.size(); l++) {
                                        int[] array = {j, k, l};
                                        putLadders(array, tmpLadderMap, tmpCanPutLadderMap);
                                    }
                                }
                            }
                        }
                    }
                }
                i++;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void putLadders(int[] array, boolean[][] tmpLadderMap, boolean[][] tmpCanPutLadderMap) {
        int token = array.length;
        for (int i = 0; i < array.length; i++) {
            int X = x.get(array[i]);
            int Y = y.get(array[i]);
            if (!tmpCanPutLadderMap[X][Y]) {
                tmpLadderMap[X][Y] = true;
                tmpCanPutLadderMap[X][Y] = true;
                if (tmpCanPutLadderMap[0].length > 0) {
                    if (Y == 0) {
                        tmpCanPutLadderMap[X][1] = true;
                    } else if (Y == tmpCanPutLadderMap[0].length - 1) {
                        tmpCanPutLadderMap[X][Y - 1] = true;
                    } else {
                        tmpCanPutLadderMap[X][Y + 1] = true;
                        tmpCanPutLadderMap[X][Y - 1] = true;
                    }
                }
                token--;
            }
        }

        if (token == 0) {
            if (isAnswer(tmpLadderMap)) {
                //System.out.println("찾음");
                answer = array.length;
                return;
            }
        } else {
            for (int a = 0; a < tmpLadderMap.length; a++) {
                for (int m = 0; m < tmpLadderMap[0].length; m++) {
                    tmpLadderMap[a][m] = ladderMap[a][m];
                    tmpCanPutLadderMap[a][m] = canPutLadderMap[a][m];
                }
            }
        }
    }

    private static boolean isAnswer(boolean[][] tmpLadderMap) {
        boolean isAnswer = true;
        for (int i = 0; i <= tmpLadderMap[0].length; i++) {
            int colIndex = i;
            int rowIndex = 0;
            while (rowIndex < tmpLadderMap.length) {
                if (colIndex == 0) { //오른쪽만
                    if (tmpLadderMap[rowIndex][colIndex]) {
                        colIndex++;
                    }
                } else if (colIndex == tmpLadderMap[0].length) {
                    if (tmpLadderMap[rowIndex][colIndex - 1]) {
                        colIndex--;
                    }
                } else {
                    if (tmpLadderMap[rowIndex][colIndex]) {
                        colIndex++;
                    } else if (tmpLadderMap[rowIndex][colIndex - 1]) {
                        colIndex--;
                    }
                }
                rowIndex++;
            }
            if (colIndex != i) {
                isAnswer = false;
                break;
            }
        }
        return isAnswer;
    }
}
