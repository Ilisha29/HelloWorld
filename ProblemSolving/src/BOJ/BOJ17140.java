package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10 : 48 start
public class BOJ17140 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[100][100];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int c = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int k = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }

        int answer = 0;
        while (answer <= 100) {
            if (map[r][c] == k) {
                break;
            }
            answer++;
            int rowMax = 0;
            int colMax = 0;

            //rowMax연산
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (map[j][i] != 0) {
                        rowMax = j > rowMax ? j : rowMax;
                    }
                    if (map[j][i] == 0) {
                        break;
                    }
                }
            }
            //colMax연산
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (map[i][j] != 0) {
                        colMax = j > colMax ? j : colMax;
                    }
                    if (map[i][j] == 0) {
                        break;
                    }
                }
            }
            rowMax++;
            colMax++;

            if (rowMax >= colMax) {
                //R연산
                for (int i = 0; i < rowMax; i++) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = 0; j < 100; j++) {
                        if (map[i][j] != 0) {
                            arrayList.add(map[i][j]);
                        }
                    }
                    int[] rowArray = new int[arrayList.size()];
                    for (int j = 0; j < arrayList.size(); j++) {
                        rowArray[j] = arrayList.get(j);
                    }
                    arrayRowSort(rowArray, i);
                }
            } else {
                //C연산
                for (int i = 0; i < colMax; i++) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = 0; j < 100; j++) {
                        if (map[j][i] != 0) {
                            arrayList.add(map[j][i]);
                        }
                    }
                    int[] colArray = new int[arrayList.size()];
                    for (int j = 0; j < arrayList.size(); j++) {
                        colArray[j] = arrayList.get(j);
                    }
                    arrayColSort(colArray, i);
                }
            }
        }

        //정답 출력
        if (answer > 100) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
        bufferedReader.close();
    }

    private static void arrayColSort(int[] colArray, int col) {
        int[] array = new int[101];
        for (int i = 0; i < colArray.length; i++) {
            if (colArray[i] == 0) {
                break;
            }

            array[colArray[i]]++;
        }

        int maxNum = 0;
        for (int i = 0; i < array.length; i++) {
            maxNum = array[i] > maxNum ? array[i] : maxNum;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int s = 1;
        while (maxNum >= s) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == s) {
                    arrayList.add(i);
                    arrayList.add(array[i]);
                    array[i] = 0;
                    continue;
                }
            }
            s++;
        }

        for (int i = 0; i < 100; i++) {
            map[i][col] = 0;
        }

        int rep = arrayList.size();
        if (rep > 100) {
            for (int i = 0; i < 100; i++) {
                map[i][col] = arrayList.get(i);
            }
        } else {
            for (int i = 0; i < rep; i++) {
                map[i][col] = arrayList.get(i);
            }
        }


    }

    private static void arrayRowSort(int[] rowArray, int row) {
        int[] array = new int[101];
        for (int i = 0; i < rowArray.length; i++) {
            if (rowArray[i] == 0) {
                break;
            }
            array[rowArray[i]]++;
        }

        int maxNum = 0;
        for (int i = 0; i < array.length; i++) {
            maxNum = array[i] > maxNum ? array[i] : maxNum;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int j = 1;
        while (j <= maxNum) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == j) {
                    arrayList.add(i);
                    arrayList.add(array[i]);
                    array[i] = 0;
                    continue;
                }
            }
            j++;
        }

        for (int i = 0; i < 100; i++) {
            map[row][i] = 0;
        }

        int rep = arrayList.size();
        if (rep > 100) {
            for (int i = 0; i < 100; i++) {
                map[row][i] = arrayList.get(i);
            }
        } else {
            for (int i = 0; i < rep; i++) {
                map[row][i] = arrayList.get(i);
            }
        }

    }
}
// 13 : 07 end
// 구현하는 문제인데 짜임새 있게 짜지 않아서 논리에서 틀린 부분이 많아서 시간이 너무 오래걸렸다.