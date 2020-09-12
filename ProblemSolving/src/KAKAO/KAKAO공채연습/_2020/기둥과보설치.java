package KAKAO.KAKAO공채연습._2020;

import java.util.ArrayList;

public class 기둥과보설치 {
    public static void main(String[] args) {
        //int[][] input = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] input = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int[][] result = solution(5, input);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    //기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
    //보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
    static boolean[][] col = new boolean[101][101];
    static boolean[][] row = new boolean[101][101];

    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (a == 0 && b == 1) { //기둥설치
                if (check_col(x, y, n)) {
                    col[x][y] = true;
                }
            } else if (a == 1 && b == 1) { //보설치
                if (check_row(x, y, n)) {
                    row[x][y] = true;
                }
            } else if (a == 0 && b == 0) { //기둥삭제
                boolean isCanDestroy = true;
                col[x][y] = false;

                if (y < n && col[x][y + 1] && !check_col(x, y + 1, n)) isCanDestroy = false;
                else if (y < n && row[x][y + 1] && !check_row(x, y + 1, n)) isCanDestroy = false;
                else if (x > 0 && row[x - 1][y + 1] && y < n && !check_row(x - 1, y + 1, n)) isCanDestroy = false;

                if (!isCanDestroy) col[x][y] = true;
            } else { //보삭제
                boolean isCanDestroy = true;
                row[x][y] = false;

                if (col[x][y] && !check_col(x, y, n)) isCanDestroy = false;
                else if (x < n && col[x + 1][y] && !check_col(x + 1, y, n)) isCanDestroy = false;
                else if (x > 0 && row[x - 1][y] && !check_row(x - 1, y, n)) isCanDestroy = false;
                else if (x < n && row[x + 1][y] && !check_row(x + 1, y, n)) isCanDestroy = false;

                if (!isCanDestroy) row[x][y] = true;
            }

        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (col[i][j]) {
                    String tmp = Integer.toString(i) + " " + Integer.toString(j) + " 0";
                    arrayList.add(tmp);
                }
                if (row[i][j]) {
                    String tmp = Integer.toString(i) + " " + Integer.toString(j) + " 1";
                    arrayList.add(tmp);
                }
            }
        }
        int[][] answer = new int[arrayList.size()][3];
        for (int i = 0; i < answer.length; i++) {
            String[] strings = arrayList.get(i).split(" ");
            answer[i][0] = Integer.parseInt(strings[0]);
            answer[i][1] = Integer.parseInt(strings[1]);
            answer[i][2] = Integer.parseInt(strings[2]);
        }
        return answer;
    }

    private static boolean check_col(int x, int y, int n) {
        if (y == 0) return true;
        if (col[x][y - 1]) return true;
        if (x > 0 && row[x - 1][y]) return true;
        if (x < n && row[x][y]) return true;
        return false;
    }

    private static boolean check_row(int x, int y, int n) {
        if (col[x][y - 1]) return true;
        if (x < n && col[x + 1][y - 1]) return true;
        if (x > 0 && x < n && row[x + 1][y] && row[x - 1][y]) return true;
        return false;
    }
}
/*
public static int[][] solution(int n, int[][] build_frame) {
        int[][] structures = new int[n + 1][n + 1]; // 1 : only col / 2 : only plate / 3 : both
        for (int i = 0; i < build_frame.length; i++) {
            int y = build_frame[i][0];
            int x = build_frame[i][1];
            int structureType = build_frame[i][2]; // 0 column, 1 plate
            int installOrDestroy = build_frame[i][3]; // 0 destroy, 1 install
            if (installOrDestroy == 1) { // install
                if (structureType == 0) { // column
                    if (x == 0) {
                        installColumn(x, y, structures);
                    } else if (isInstallColumn(x - 1, y, structures)) {
                        installColumn(x, y, structures);
                    } else if (y > 0 && isInstallPlate(x, y - 1, structures)) {
                        installColumn(x, y, structures);
                    } else if (isInstallPlate(x, y, structures)) {
                        installColumn(x, y, structures);
                    }
                } else { // plate
                    if (isInstallColumn(x - 1, y, structures) || isInstallColumn(x - 1, y + 1, structures)) {
                        installPlate(x, y, structures);
                    } else if (y > 0 && y < n && isInstallPlate(x, y - 1, structures) && isInstallPlate(x, y + 1, structures)) {
                        installPlate(x, y, structures);
                    }
                }
            } else { //destroy
                int originValue = structures[x][y];
                if (structureType == 0) { // coloumn
                    if (structures[x][y] == 1) {
                        structures[x][y] = 0;
                    } else {
                        structures[x][y] = 2;
                    }
                } else { // plate
                    if (structures[x][y] == 2) {
                        structures[x][y] = 0;
                    } else {
                        structures[x][y] = 1;
                    }
                }
                if (!isAllConditionPass(structures)) {
                    structures[x][y] = originValue;
                }
            }
        }
        int answerLength = 0;
        for (int i = 0; i < structures.length; i++) {
            for (int j = 0; j < structures.length; j++) {
                if (structures[i][j] == 3) {
                    answerLength += 2;
                } else if (structures[i][j] != 0) {
                    answerLength += 1;
                }
            }
        }
        int[][] answer = new int[answerLength][3];
        int index = 0;
        for (int i = 0; i < structures.length; i++) {
            for (int j = 0; j < structures.length; j++) {
                if (structures[i][j] == 3) {
                    answer[index][0] = j;
                    answer[index][1] = i;
                    answer[index++][2] = 0;
                    answer[index][0] = j;
                    answer[index][1] = i;
                    answer[index++][2] = 1;
                } else if (structures[i][j] == 2) {
                    answer[index][0] = j;
                    answer[index][1] = i;
                    answer[index++][2] = 1;
                } else if (structures[i][j] == 1) {
                    answer[index][0] = j;
                    answer[index][1] = i;
                    answer[index++][2] = 0;
                }
            }
        }
        return answer;
    }

    private static boolean isAllConditionPass(int[][] structures) {
        for (int i = 0; i < structures.length; i++) {
            for (int j = 0; j < structures.length; j++) {
                if (structures[i][j] == 3) {
                    if (!isPlateConditionCheck(i, j, structures)) {
                        return false;
                    }
                    if (!isColumnConditionCheck(i, j, structures)) {
                        return false;
                    }
                } else if (structures[i][j] == 2) {
                    if (!isPlateConditionCheck(i, j, structures)) {
                        return false;
                    }
                } else if (structures[i][j] == 1) {
                    if (!isColumnConditionCheck(i, j, structures)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isColumnConditionCheck(int i, int j, int[][] structures) {
        if (i == 0) {
            return true;
        } else if (isInstallColumn(i - 1, j, structures)) {
            return true;
        } else if (isInstallPlate(i, j, structures) || isInstallPlate(i - 1, j, structures)) {
            return true;
        }
        return false;
    }

    private static boolean isPlateConditionCheck(int i, int j, int[][] structures) {
        if (isInstallColumn(i - 1, j, structures) || isInstallColumn(i - 1, j + 1, structures)) {
            return true;
        } else if (j > 0 && j < structures.length - 1 && isInstallPlate(i, j - 1, structures) && isInstallColumn(i, j + 1, structures)) {
            return true;
        }
        return false;
    }


    private static void installPlate(int x, int y, int[][] structures) {
        if (structures[x][y] == 0) {
            structures[x][y] = 2;
        } else {
            structures[x][y] = 3;
        }
    }

    private static boolean isInstallPlate(int x, int y, int[][] structure) {
        if (structure[x][y] == 2 || structure[x][y] == 3) {
            return true;
        }
        return false;
    }

    private static boolean isInstallColumn(int x, int y, int[][] structure) {
        if (structure[x][y] == 1 || structure[x][y] == 3) {
            return true;
        }
        return false;
    }

    private static void installColumn(int x, int y, int[][] structures) {
        if (structures[x][y] == 0) {
            structures[x][y] = 1;
        } else {
            structures[x][y] = 3;
        }
    }
 */

