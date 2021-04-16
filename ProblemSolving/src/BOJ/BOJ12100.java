package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 20 : 40 start
public class BOJ12100 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int answer = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    for (int l = 1; l < 5; l++) {
                        for (int m = 1; m < 5; m++) {

                            int[] orders = {i, j, k, l, m};
                            int[][] tmpMap = new int[N][N];
                            for (int n = 0; n < N; n++) {
                                for (int o = 0; o < N; o++) {
                                    tmpMap[n][o] = map[n][o];
                                }
                            }

                            for (int n = 0; n < orders.length; n++) {
                                if (orders[n] == 1) { //위
                                    //배열넘기기
                                    for (int o = 0; o < N; o++) {
                                        int[] array = new int[N];
                                        for (int p = 0; p < N; p++) {
                                            array[p] = tmpMap[p][o];
                                        }
                                        array = E048(array);
                                        for (int p = 0; p < N; p++) {
                                            tmpMap[p][o] = array[p];
                                        }
                                    }
                                } else if (orders[n] == 2) { //오른
                                    //배열넘기기
                                    for (int o = 0; o < N; o++) {
                                        int[] array = new int[N];
                                        for (int p = 0; p < N; p++) {
                                            array[p] = tmpMap[o][N - 1 - p];
                                        }
                                        array = E048(array);
                                        for (int p = 0; p < N; p++) {
                                            tmpMap[o][N - 1 - p] = array[p];
                                        }
                                    }
                                } else if (orders[n] == 3) { //아래쪽
                                    // 배열넘기기
                                    for (int o = 0; o < N; o++) {
                                        int[] array = new int[N];
                                        for (int p = 0; p < N; p++) {
                                            array[p] = tmpMap[N - 1 - p][o];
                                        }
                                        array = E048(array);
                                        for (int p = 0; p < N; p++) {
                                            tmpMap[N - 1 - p][o] = array[p];
                                        }
                                    }
                                } else if (orders[n] == 4) { //왼쪽
                                    //배열넘기기
                                    for (int o = 0; o < N; o++) {
                                        int[] array = new int[N];
                                        for (int p = 0; p < N; p++) {
                                            array[p] = tmpMap[o][p];
                                        }
                                        array = E048(array);
                                        for (int p = 0; p < N; p++) {
                                            tmpMap[o][p] = array[p];
                                        }
                                    }
                                }
                            }
                            for (int n = 0; n < N; n++) {
                                for (int o = 0; o < N; o++) {
                                    answer = tmpMap[n][o] > answer ? tmpMap[n][o] : answer;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static int[] E048(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] tmpArray = new int[array.length + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                tmpArray[index++] = array[i];
            }
        }
        tmpArray[array.length] = -1;

        for (int i = 0; i < tmpArray.length - 1; i++) {
            if (tmpArray[i] != tmpArray[i + 1]) {
                arrayList.add(tmpArray[i]);
            } else {
                arrayList.add(tmpArray[i] * 2);
                i++;
            }
        }

        int[] newArray = new int[array.length];
        for (int i = 0; i < arrayList.size(); i++) {
            newArray[i] = arrayList.get(i);
        }
        return newArray;
    }
}
// 22 : 10 1st time
// 1시간 구현 30분 코드 한줄 때문에 삽질