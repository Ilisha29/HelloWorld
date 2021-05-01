package KAKAO.KAKAO2020공채.prac1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class K4 {
    public static void main(String[] args) {
        int[] n = {5, 5};
        int[][][] build_frame = {
                {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}},
                {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}
        };
        for (int i = 0; i < n.length; i++) {
            int[][] result = solution(n[i], build_frame[i]);
            for (int j = 0; j < result.length; j++) {
                for (int k = 0; k < result[0].length; k++) {
                    System.out.print(result[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("===============");
        }
    }

    private static Structure[][] map;
    private static int X;
    private static int Y;

    public static int[][] solution(int n, int[][] build_frame) {
        X = n + 1;
        Y = n + 1;
        map = new Structure[n + 1][n + 1];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                map[i][j] = new Structure(false, false);
            }
        }
        for (int i = 0; i < build_frame.length; i++) {
            int y = build_frame[i][0];
            int x = build_frame[i][1];
            int type = build_frame[i][2];
            int installOrDestroy = build_frame[i][3];
            if (type == 0) { // 기둥
                if (installOrDestroy == 0) { // 삭제
                    boolean isOk = true;
                    map[x][y].column = false;
                    for (int j = 0; j < X; j++) {
                        for (int k = 0; k < Y; k++) {
                            if (!isConditionOk(j, k)) {
                                isOk = false;
                                break;
                            }
                        }
                    }
                    if (!isOk) {
                        map[x][y].column = true;
                    }
                } else { // 설치
                    if (x == 0) {
                        map[x][y].column = true;
                    } else {
                        if (map[x - 1][y].column || map[x][y].row) {
                            map[x][y].column = true;
                        } else if (y >= 1 && map[x][y - 1].row) {
                            map[x][y].column = true;
                        }
                    }
                }
            } else { // 보
                if (installOrDestroy == 0) { // 삭제
                    boolean isOk = true;
                    map[x][y].row = false;
                    for (int j = 0; j < X; j++) {
                        for (int k = 0; k < Y; k++) {
                            if (!isConditionOk(j, k)) {
                                isOk = false;
                                break;
                            }
                        }
                    }
                    if (!isOk) {
                        map[x][y].row = true;
                    }
                } else { // 설치
                    if (x == 0) {
                        continue;
                    } else if (map[x - 1][y].column || map[x - 1][y + 1].column) {
                        map[x][y].row = true;
                    } else {
                        if (y >= 1 && y < Y) {
                            if (map[x][y - 1].row && map[x][y + 1].row) {
                                map[x][y].row = true;
                            }
                        }
                    }
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j].column) {
                    int[] tmp = new int[3];
                    tmp[0] = j;
                    tmp[1] = i;
                    tmp[2] = 0;
                    arrayList.add(tmp);
                }
                if (map[i][j].row) {
                    int[] tmp = new int[3];
                    tmp[0] = j;
                    tmp[1] = i;
                    tmp[2] = 1;
                    arrayList.add(tmp);
                }
            }
        }
        //System.out.println(arrayList.size());
        Collections.sort(arrayList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return o1[2] - o2[2];
                    }
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[][] answer = new int[arrayList.size()][3];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    private static boolean isConditionOk(int x, int y) {
        boolean col = true;
        boolean row = true;

        if (map[x][y].column) {
            if (x != 0 && !map[x - 1][y].column && (!checkColumnCondition(x, y))) {
                col = false;
            }
        }

        if (map[x][y].row) {
            if (y == 0 || y == Y - 1) {
                if (!map[x - 1][y].column && !map[x - 1][y + 1].column) {
                    row = false;
                }
            } else {
                if ((!map[x - 1][y].column && !map[x - 1][y + 1].column) && !(map[x][y - 1].row && map[x][y + 1].row)) {
                    row = false;
                }
            }
        }
        return col && row;
    }

    private static boolean checkColumnCondition(int x, int y) {
        if (y == 0) {
            if (map[x][y].row) {
                return true;
            }
        } else if (y == Y - 1) {
            if (map[x][y - 1].row) {
                return true;
            }
        } else {
            if (map[x][y - 1].row || map[x][y].row) {
                return true;
            }
        }
        return false;
    }
}

class Structure {
    boolean column;
    boolean row;

    public Structure(boolean column, boolean row) {
        this.column = column;
        this.row = row;
    }
}