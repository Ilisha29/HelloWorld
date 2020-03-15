package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14 : 30 start
public class BOJ14890 {
    static int[][] map;
    static int answer;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        answer = 0;
        //가로
        for (int i = 0; i < N; i++) {
            ramp(map[i]);
        }
        //세로
        for (int i = 0; i < N; i++) {
            int[] array = new int[N];
            for (int j = 0; j < N; j++) {
                array[j] = map[j][i];
            }
            ramp(array);
        }

        System.out.println(answer);
        bufferedReader.close();
    }

    private static void ramp(int[] array) {
        int tmpLength = 1;
        int tmpHeigth = array[0];
        int i;
        for (i = 1; i < array.length; i++) {
            if (array[i] == tmpHeigth) {
                tmpLength++;
            }
            if (array[i] > tmpHeigth) {
                if (array[i] - tmpHeigth == 1 && tmpLength >= L) {
                    tmpLength = 1;
                    tmpHeigth = array[i];
                    continue;
                } else {
                    break;
                }
            }
            if (array[i] < tmpHeigth) {
                if (tmpHeigth - array[i] > 1) {
                    break;
                } else {
                    int index = i + (L - 1);
                    if (index >= array.length) {
                        break;
                    } else {
                        int heigh = array[i];
                        boolean allSame = true;
                        for (int j = i; j <= index; j++) {
                            if (array[j] != heigh) {
                                allSame = false;
                                break;
                            }
                        }
                        if (!allSame) {
                            break;
                        }
                        i = index;
                        tmpHeigth = array[i];
                        tmpLength = 0;
                    }
                }
            }

        }
        if (i == array.length) {
            answer++;
        }
    }
}
// 14 : 30 end
// ? 쉽네;;;