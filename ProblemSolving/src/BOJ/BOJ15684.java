package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ15684 {
    static ArrayList<Integer> x;
    static ArrayList<Integer> y;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int col = Integer.parseInt(strings[0]) - 1;
        int N = Integer.parseInt(strings[1]);
        int row = Integer.parseInt(strings[2]);
        boolean[][] ladderMap = new boolean[row][col];
        for (int i = 0; i < N; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            ladderMap[Integer.parseInt(strings1[0]) - 1][Integer.parseInt(strings1[1]) - 1] = true;
        }
        int answer = -1;
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
        boolean[][] canPutLadderMap = new boolean[row][col];
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
                            boolean[][] tmpLadderMap = new boolean[row][col];
                            for (int l = 0; l < row; l++) {
                                for (int m = 0; m < col; m++) {
                                    tmpLadderMap[l][m] = ladderMap[l][m];
                                }
                            }
                            tmpLadderMap[x.get(j)][y.get(j)] = true;
                            if (isAnswer(tmpLadderMap)) {
                                answer = 1;
                                break;
                            }
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
                                for (int k = j; k < x.size(); k++) {
                                    if (j != k) {
                                        boolean[][] tmpLadderMap = new boolean[row][col];
                                        boolean[][] tmpCanPutLadderMap = new boolean[row][col];
                                        for (int a = 0; a < row; a++) {
                                            for (int m = 0; m < col; m++) {
                                                tmpLadderMap[a][m] = ladderMap[a][m];
                                                tmpCanPutLadderMap[a][m] = canPutLadderMap[a][m];
                                            }
                                        }
                                        int[] array = {j, k};
                                        if (aa(array, tmpLadderMap, tmpCanPutLadderMap)) {
                                            tmpLadderMap[x.get(j)][y.get(j)] = true;
                                            tmpLadderMap[x.get(k)][y.get(k)] = true;
                                            for (int l = 0; l < row; l++) {
                                                for (int m = 0; m < col; m++) {
                                                    System.out.print(tmpLadderMap[l][m] + " ");
                                                }
                                                System.out.println();
                                            }
                                            System.out.println("===================");
                                            if (isAnswer(tmpLadderMap)) {
                                                answer = 2;
                                                break;
                                            }
                                        }
                                    }
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
                                for (int k = j; k < x.size() - 1; k++) {
                                    for (int l = k; l < x.size(); l++) {
                                        if (j != k && k != l && l != j) {
                                            boolean[][] tmpLadderMap = new boolean[row][col];
                                            boolean[][] tmpCanPutLadderMap = new boolean[row][col];
                                            for (int a = 0; a < row; a++) {
                                                for (int m = 0; m < col; m++) {
                                                    tmpLadderMap[a][m] = ladderMap[a][m];
                                                    tmpCanPutLadderMap[a][m] = canPutLadderMap[a][m];
                                                }
                                            }
                                            int[] array = {j, k, l};
                                            if (aa(array, tmpLadderMap, tmpCanPutLadderMap)) {
                                                tmpLadderMap[x.get(j)][y.get(j)] = true;
                                                tmpLadderMap[x.get(k)][y.get(k)] = true;
                                                tmpLadderMap[x.get(l)][y.get(l)] = true;
                                                if (isAnswer(tmpLadderMap)) {
                                                    answer = 3;
                                                    break;
                                                }
                                            }
                                        }
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

    private static boolean aa(int[] array, boolean[][] tmpLadderMap, boolean[][] tmpCanPutLadderMap) {
        boolean a = true;
        int token = array.length;
        for (int i = 0; i < array.length; i++) {
            int X = x.get(array[i]);
            int Y = y.get(array[i]);
            if (!tmpCanPutLadderMap[X][Y]) {
                tmpLadderMap[X][Y] = true;
                tmpCanPutLadderMap[X][Y] = true;
                if (tmpCanPutLadderMap[0].length > 1) {
                    if (Y == 0) {
                        tmpCanPutLadderMap[X][1] = true;
                    } else if (Y == tmpCanPutLadderMap[0].length - 1) {
                        tmpCanPutLadderMap[X][Y] = true;
                    } else {
                        tmpCanPutLadderMap[X][Y + 1] = true;
                        tmpCanPutLadderMap[X][Y - 1] = true;
                    }
                }
                token--;
            }
        }

        if (token != 0) {
            a = false;
        }
        return a;
    }

    private static boolean isAnswer(boolean[][] tmpLadderMap) {
        boolean isAnswer = true;
        for (int i = 0; i < tmpLadderMap[0].length; i++) {
            int ladderNum = 0;
            for (int j = 0; j < tmpLadderMap.length; j++) {
                if (tmpLadderMap[j][i]) {
                    ladderNum++;
                }
            }
            if (ladderNum % 2 == 1) {
                isAnswer = false;
                break;
            }
        }
        for (int i = 0; i < tmpLadderMap[0].length - 1; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < tmpLadderMap.length; j++) {
                if (tmpLadderMap[j][i]) {
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        if (stack.peek() != i) {
                            stack.push(i);
                        } else {
                            stack.pop();
                        }
                    }
                } else if (tmpLadderMap[j][i + 1]) {
                    if (stack.isEmpty()) {
                        stack.push(i + 1);
                    } else {
                        if (stack.peek() != i + 1) {
                            stack.push(i + 1);
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                isAnswer = false;
                break;
            }
        }
        return isAnswer;
    }
}
