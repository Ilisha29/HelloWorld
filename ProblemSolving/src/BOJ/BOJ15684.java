package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15684 {
    static boolean[][] radderMap;
    static boolean[][] canPutRadderMap;
    static int answer;
    static boolean findAnswer;
    static ArrayList<Integer> rowIndex;
    static ArrayList<Integer> colIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int col = Integer.parseInt(strings[0]);
        int radderNum = Integer.parseInt(strings[1]);
        int row = Integer.parseInt(strings[2]);
        radderMap = new boolean[row][col - 1];
        canPutRadderMap = new boolean[row][col - 1];
        answer = -1;
        for (int i = 0; i < radderNum; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            radderMap[Integer.parseInt(strings1[0]) - 1][Integer.parseInt(strings1[1]) - 1] = true;
        }
        if (canPutRadderMap[0].length > 1) {
            for (int i = 0; i < radderMap.length; i++) {
                for (int j = 0; j < radderMap[0].length; j++) {
                    if (radderMap[i][j]) {
                        if (j == 0) {
                            canPutRadderMap[i][j + 1] = true;
                        } else if (j == canPutRadderMap[0].length - 1) {
                            canPutRadderMap[i][j - 1] = true;
                        } else {
                            canPutRadderMap[i][j + 1] = true;
                            canPutRadderMap[i][j - 1] = true;
                        }
                    }
                }
            }
        }

        int canPutAreaNum = 0;
        rowIndex = new ArrayList<>();
        colIndex = new ArrayList<>();
        for (int i = 0; i < canPutRadderMap.length; i++) {
            for (int j = 0; j < canPutRadderMap[0].length; j++) {
                if (!canPutRadderMap[i][j]) {
                    rowIndex.add(i);
                    colIndex.add(j);
                    canPutAreaNum++;
                }
            }
        }
        int[] arr = new int[canPutAreaNum];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        boolean[] visited = new boolean[arr.length];
        findAnswer = false;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                if (isAnswer(radderMap)) {
                    findAnswer = true;
                }
            } else {
                combination(arr, visited, 0, arr.length, i, i);
            }
            if (findAnswer) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
        //확인
        /*for (int i = 0; i < radderMap.length; i++) {
            for (int j = 0; j < radderMap[0].length; j++) {
                System.out.print(radderMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=============================");
        for (int i = 0; i < radderMap.length; i++) {
            for (int j = 0; j < radderMap[0].length; j++) {
                System.out.print(canPutRadderMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        bufferedReader.close();
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r, int num) {
        if (r == 0) {
            if (findAnswer) {
                return;
            }
            if (num == 1) {
                boolean[][] tmpMap = new boolean[radderMap.length][radderMap[0].length];
                for (int i = 0; i < radderMap.length; i++) {
                    for (int j = 0; j < radderMap[0].length; j++) {
                        tmpMap[i][j] = radderMap[i][j];
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        tmpMap[rowIndex.get(i)][colIndex.get(i)] = true;
                    }
                }
                if (isAnswer(tmpMap)) {
                    findAnswer = true;
                }
            } else if (num == 2) {
                boolean[][] tmpMap = new boolean[radderMap.length][radderMap[0].length];
                for (int i = 0; i < radderMap.length; i++) {
                    for (int j = 0; j < radderMap[0].length; j++) {
                        tmpMap[i][j] = radderMap[i][j];
                    }
                }
                int[][] indexArr = new int[num][2];
                int index = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        indexArr[index][0] = rowIndex.get(i);
                        indexArr[index++][1] = colIndex.get(i);
                    }
                }
                int x1 = indexArr[0][0];
                int y1 = indexArr[0][1];
                int x2 = indexArr[1][0];
                int y2 = indexArr[1][1];
                if (x1 != x2) {
                    tmpMap[x1][y1] = true;
                    tmpMap[x2][y2] = true;
                    if (isAnswer(tmpMap)) {
                        findAnswer = true;
                    }
                } else {
                    if (Math.abs(y1 - y2) != 1) {
                        tmpMap[x1][y1] = true;
                        tmpMap[x2][y2] = true;
                        if (isAnswer(tmpMap)) {
                            findAnswer = true;
                        }
                    }
                }
            } else {
                boolean[][] tmpMap = new boolean[radderMap.length][radderMap[0].length];
                for (int i = 0; i < radderMap.length; i++) {
                    for (int j = 0; j < radderMap[0].length; j++) {
                        tmpMap[i][j] = radderMap[i][j];
                    }
                }

                int[][] indexArr = new int[num][2];
                int index = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        indexArr[index][0] = rowIndex.get(i);
                        indexArr[index++][1] = colIndex.get(i);
                    }
                }

                int x1 = indexArr[0][0];
                int y1 = indexArr[0][1];
                int x2 = indexArr[1][0];
                int y2 = indexArr[1][1];
                int x3 = indexArr[2][0];
                int y3 = indexArr[2][1];

                if ((x1 != x2 || Math.abs(y1 - y2) != 1) && (x2 != x3 || Math.abs(y2 - y3) != 1) && (x1 != x3 || Math.abs(y1 - y3) != 1)) {
                    tmpMap[x1][y1] = true;
                    tmpMap[x2][y2] = true;
                    tmpMap[x3][y3] = true;
                    if (isAnswer(tmpMap)) {
                        findAnswer = true;
                    }
                }
            }
            return;

        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, num);
            visited[i] = false;
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
