package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        //1. 구역나누기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 1; k < N; k++) { //d1
                    for (int l = 1; l < N; l++) { //d2
                        if (i < i + k + l && i + k + l <= N - 1 && 0 <= j - k && j - k < j && j < j + l && j + l <= N - 1) {
                            //2. 구역 번호 부여
                            int[][] areaMap = new int[N][N];
                            for (int m = 0; m <= k; m++) { //d1
                                areaMap[i + m][j - m] = 5;
                                areaMap[i + l + m][j + l - m] = 5;
                            }
                            for (int m = 0; m <= l; m++) { //d2
                                areaMap[i + m][j + m] = 5;
                                areaMap[i + k + m][j - k + m] = 5;
                            }
                            for (int m = i + 1; m < i + k + l; m++) {
                                int[] indexY = new int[2];
                                int index = 0;
                                for (int n = 0; n < N; n++) {
                                    if (areaMap[m][n] == 5) {
                                        indexY[index++] = n;
                                    }

                                }
                                for (int o = indexY[0]; o < indexY[1]; o++) {
                                    areaMap[m][o] = 5;
                                }
                            }
                            for (int m = 0; m < i + k; m++) {
                                for (int n = 0; n <= j; n++) {
                                    if (areaMap[m][n] == 0) {
                                        areaMap[m][n] = 1;
                                    }
                                }
                            }
                            for (int m = 0; m <= i + l; m++) {
                                for (int n = j + 1; n < N; n++) {
                                    if (areaMap[m][n] == 0) {
                                        areaMap[m][n] = 2;
                                    }
                                }
                            }
                            for (int m = i + k; m < N; m++) {
                                for (int n = 0; n < j - k + l; n++) {
                                    if (areaMap[m][n] == 0) {
                                        areaMap[m][n] = 3;
                                    }
                                }
                            }
                            for (int m = i + l; m < N; m++) {
                                for (int n = j - k + l - 1; n < N; n++) {
                                    if (areaMap[m][n] == 0) {
                                        areaMap[m][n] = 4;
                                    }
                                }
                            }
                            //3. 정답 계산
                            int[] sumArray = new int[5];
                            for (int m = 0; m < N; m++) {
                                for (int n = 0; n < N; n++) {
                                    sumArray[areaMap[m][n] - 1] += map[m][n];
                                }
                            }
                            Arrays.sort(sumArray);
                            int tmpAnswer = sumArray[4] - sumArray[0];
                            answer = tmpAnswer < answer ? tmpAnswer : answer;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
