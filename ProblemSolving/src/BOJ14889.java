import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int[][] map;
    static int startPower;
    static int rinkPower;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int gap = (size * size - size) * 100;
        for (int i = 0; i < Math.pow(2, size); i++) {
            int N = i;
            int[] array = new int[size];
            int index = 0;
            while (N >= 2) {
                array[index++] = N % 2;
                N /= 2;
            }
            array[index] = N;
            int zeroNum = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 0) {
                    zeroNum++;
                }
            }
            if (zeroNum == size / 2) {
                int[] start = new int[size / 2];
                int[] rink = new int[size / 2];
                int startIndex = 0;
                int rinkIndex = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 0) {
                        start[startIndex++] = j;
                    } else {
                        rink[rinkIndex++] = j;
                    }
                }
                int index1 = 0;
                int index2 = index1 + 1;
                combination(index1, index2, start);

                int index3 = 0;
                int index4 = index3 + 1;
                combination2(index3, index4, rink);

                int tmpGap = Math.abs(startPower - rinkPower);
                gap = (tmpGap < gap) ? tmpGap : gap;
                startPower = 0;
                rinkPower = 0;
            }
        }
        System.out.println(gap);
        bufferedReader.close();
    }

    private static void combination(int index1, int index2, int[] tmp) {
        startPower += map[tmp[index1]][tmp[index2]] + map[tmp[index2]][tmp[index1]];
        if (index1 == tmp.length - 2) return;
        else {
            if (index2 == tmp.length - 1) {
                index1++;
                index2 = index1 + 1;
                combination(index1, index2, tmp);
            } else {
                index2++;
                combination(index1, index2, tmp);
            }
        }
    }

    private static void combination2(int index3, int index4, int[] rink) {
        rinkPower += map[rink[index3]][rink[index4]] + map[rink[index4]][rink[index3]];
        if (index3 == rink.length - 2) return;
        else {
            if (index4 == rink.length - 1) {
                index3++;
                index4 = index3 + 1;
                combination2(index3, index4, rink);
            } else {
                index4++;
                combination2(index3, index4, rink);
            }
        }
    }
}
